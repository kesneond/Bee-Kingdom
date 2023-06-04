import { TestBed } from '@angular/core/testing';

import { ColoniesService } from './colonies.service';

describe('ColoniesService', () => {
  let service: ColoniesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ColoniesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
