import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { HospitalService } from './hospital.service';

describe('HospitalService', () => {
  let service: HospitalService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HospitalService],
    });
    service = TestBed.inject(HospitalService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify(); // S'assure qu'il n'y a pas de requêtes en attente
  });

  it('getNearestHospital should make GET request with correct parameters', () => {
    const specialty = 'cardiology';
    const latitude = 48.8566;
    const longitude = 2.3522;
    const mockHospital = {
      id: 1,
      name: 'Hôpital Général',
      latitude: 48.8566,
      longitude: 2.3522,
      numeroDeRue: '123',
      postal: '75000',
      rue: 'Rue Imaginaire',
      lit: 200,
    };

    service
      .getNearestHospital(specialty, latitude, longitude)
      .subscribe((hospital) => {
        expect(hospital).toEqual(mockHospital);
      });

    const req = httpTestingController.expectOne(
      (req) => req.url === service.apiUrl && req.method === 'GET'
    );
    expect(req.request.params.get('specialty')).toEqual(specialty);
    expect(req.request.params.get('latitude')).toEqual(latitude.toString());
    expect(req.request.params.get('longitude')).toEqual(longitude.toString());

    req.flush(mockHospital);
  });

  it('getHospitalData should make GET request for specific hospital ID', () => {
    const hospitalId = '1'; // Assurez-vous que l'ID est une chaîne pour correspondre au type attendu par `getHospitalData`
    const mockHospital = {
      id: 1,
      name: 'Hôpital Général',
      latitude: 48.8566,
      longitude: 2.3522,
      numeroDeRue: '123',
      postal: '75000',
      rue: 'Rue Imaginaire',
      lit: 200,
    };

    service.getHospitalData(hospitalId).subscribe((hospital) => {
      expect(hospital).toEqual(mockHospital);
    });

    const req = httpTestingController.expectOne(
      `${service.apiUrl}/${hospitalId}`
    );
    expect(req.request.method).toBe('GET');

    req.flush(mockHospital);
  });

  it('getHospitalData should make GET request for current hospital when ID is not provided', () => {
    const mockHospital = {
      id: 1,
      name: 'Hôpital Général',
      latitude: 48.8566,
      longitude: 2.3522,
      numeroDeRue: '123',
      postal: '75000',
      rue: 'Rue Imaginaire',
      lit: 200,
    };

    service.getHospitalData().subscribe((hospital) => {
      expect(hospital).toEqual(mockHospital);
    });

    const req = httpTestingController.expectOne(`${service.apiUrl}/current`);
    expect(req.request.method).toBe('GET');

    req.flush(mockHospital);
  });
});
