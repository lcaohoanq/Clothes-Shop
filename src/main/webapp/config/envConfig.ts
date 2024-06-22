import { EnvConfig } from "../model/envModel";

require("dotenv").config({ path: "../../../../.env" });

export const envConfig: EnvConfig = {
  DB_URL: process.env.DB_URL,
  DB_USER: process.env.DB_USER,
  DB_PASSWORD: process.env.DB_PASSWORD,
  GOOGLE_CLIENT_ID: process.env.GOOGLE_CLIENT_ID,
  GOOGLE_REDIRECT_URI: process.env.GOOGLE_REDIRECT_URI,
  GOOGLE_LINK_GET_TOKEN: process.env.GOOGLE_LINK_GET_TOKEN,
  GOOGLE_LINK_GET_USER_INFO: process.env.GOOGLE_LINK_GET_USER_INFO,
  GOOGLE_GRANT_TYPE: process.env.GOOGLE_GRANT_TYPE,
};
