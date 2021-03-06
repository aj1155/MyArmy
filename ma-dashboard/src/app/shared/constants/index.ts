const ENV = process.env.NODE_ENV;

const VERSION_PREFIX = 'v1/';
const API_PREFIX = 'api/' + VERSION_PREFIX;
const DEFAULT_IN_MEMORY_API_URL = 'http://localhost:4200/app/' + API_PREFIX;


let defaultDashboardApiUrl = DEFAULT_IN_MEMORY_API_URL;

if (ENV === 'local-server') {
  defaultDashboardApiUrl = 'http://localhost:4200/' + API_PREFIX;
}

export const DEFAULT_DASHBOARD_API_URL = defaultDashboardApiUrl;  // URL to web api


export const FOOTER = DEFAULT_DASHBOARD_API_URL + 'footer';
export const REGIST = DEFAULT_DASHBOARD_API_URL + 'regist';
export const PERSONALREGIST = DEFAULT_DASHBOARD_API_URL + 'regist/personal';
export const COMPANYREGIST = DEFAULT_DASHBOARD_API_URL + 'regist/company';
export const COMPANY_INFO = DEFAULT_DASHBOARD_API_URL + 'info';
