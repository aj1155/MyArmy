import { MaDashboardPage } from './app.po';

describe('ma-dashboard App', () => {
  let page: MaDashboardPage;

  beforeEach(() => {
    page = new MaDashboardPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
