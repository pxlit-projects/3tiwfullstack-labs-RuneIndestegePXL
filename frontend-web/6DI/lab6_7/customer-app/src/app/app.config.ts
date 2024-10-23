import { ApplicationConfig, importProvidersFrom, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { InmemoryDataService } from './shared/services/inmemory.data.service';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideHttpClient(),
  
    importProvidersFrom(HttpClientInMemoryWebApiModule.forRoot(InmemoryDataService))
  ]

};
