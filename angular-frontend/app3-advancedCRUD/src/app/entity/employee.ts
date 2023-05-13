import { FormArray } from "@angular/forms";
import { Department } from "./department";
import { Salary } from "./salary";
import { Skill } from "./skill";

export class Employee {
    id!: number;
    firstName!: string;
    lastName!: string;
    email!: string;
    employeeSkills!: Skill[];
    dep!: Department;
    salary!: Salary;

}
