export class ModuleModel{
    id:number;
    name:String;
    creationDate:Date;
    lastModifiedDate:Date;
    active:boolean;
    constructor(name:String){
        this.name = name;
    }
}