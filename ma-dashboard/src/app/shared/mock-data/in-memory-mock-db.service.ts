import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryMockDbService implements InMemoryDbService {
  createDb() {
    return {
      //index.ts에서 설정한 서버주소로 접근시에 폴더내부에 있는 json파일 반환
      'api/v1/test': require('./ma-dashboard-test.json')
    };
  }
}
