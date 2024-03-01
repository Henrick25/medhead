import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { SearchHospitalComponent } from './search-hospital.component';
import { HospitalService } from '../hospital.service';
import { of, throwError } from 'rxjs';
import { Hospital } from '../models/hospital';

describe('SearchHospitalComponent', () => {
  let component: SearchHospitalComponent;
  let fixture: ComponentFixture<SearchHospitalComponent>;
  let hospitalService: HospitalService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SearchHospitalComponent],
      imports: [HttpClientTestingModule, FormsModule],
      providers: [HospitalService],
    }).compileComponents();

    fixture = TestBed.createComponent(SearchHospitalComponent);
    component = fixture.componentInstance;
    hospitalService = TestBed.inject(HospitalService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('searchHospital should find a hospital', () => {
    const mockHospital = {
      id: 1,
      name: 'Hôpital Général',
      latitude: 48.8566,
      longitude: 2.3522,
      lit: 200,
      numeroDeRue: '123',
      postal: '75000',
      rue: 'Rue Imaginaire',
    };
    spyOn(hospitalService, 'getNearestHospital').and.returnValue(
      of(mockHospital)
    );

    component.specialty = 'cardiology';
    component.latitude = 48.8566;
    component.longitude = 2.3522;
    component.searchHospital();

    expect(hospitalService.getNearestHospital).toHaveBeenCalledWith(
      'cardiology',
      48.8566,
      2.3522
    );
    expect(component.hospital).toEqual(mockHospital);
    expect(component.notFound).toBeFalse();
  });

  it('searchHospital should handle no hospital found', () => {
    const emptyHospital: Hospital = {
      id: 0, // Vous pouvez mettre des valeurs par défaut qui indiquent un objet "vide" ou invalide
      name: '',
      latitude: 0,
      longitude: 0,
      lit: 0,
      numeroDeRue: '',
      postal: '',
      rue: '',
    };
    spyOn(hospitalService, 'getNearestHospital').and.returnValue(
      of(emptyHospital)
    );

    component.searchHospital();

    expect(component.hospital).toEqual(emptyHospital); // Ou tout autre logique de gestion de cas vide
  });

  it('searchHospital should handle error', () => {
    const errorResponse = new ErrorEvent('Network error', {
      message: 'Les urgences sont saturées',
    });
    spyOn(hospitalService, 'getNearestHospital').and.returnValue(
      throwError(() => errorResponse)
    );

    component.searchHospital();

    expect(component.notFound).toBeTrue();
    expect(component.erreurSaisi).toContain('Les urgences sont saturées');
  });
});
