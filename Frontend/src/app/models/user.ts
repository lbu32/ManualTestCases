import {Project} from './project';

export class User {
  public userId: number;
  public firstName: string;
  public lastName: string;
  public email: string;
  public password: string;
  public created: Date;
  public companyAffiliation : Project
}
