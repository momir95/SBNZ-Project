import construct = Reflect.construct;

export class MedicalRecord
{
  constructor( public id:number,
               public lbo: string,
               public reviews: Review[],
               public patient: Patient,
               public cures: Cure[]
  ) {}
}

export class Link
{
  constructor( public text: string,
               public routerLink: string
  ){}
}

export class Review
{
  constructor( public id:number,
               public date: Date,
               public cures: Cure[],
               public disease: Disease,
               public symptoms: Symptom[],
               public doctor: User
  ){}
}

export class Patient
{
  constructor( public id:number,
               public firstname: string,
               public lastname: string
  ){}
}

export class Cure {
  constructor(public id: number,
              public name: string,
              public ingredients: Ingredient[],
              public cureType: string
  ) {}
}

export class Disease
{
  constructor( public id:number,
               public name: string,
               public diseaseGroup: string,
               public symptoms: Symptom[]
  ) {}
}

export class Symptom
{
  constructor( public id:number,
               public name: string,
               public symptomType: string
  ) {}
}

export class Ingredient
{
  constructor( public id:number,
               public name: string
  ) {}
}

export class SignUpRequest
{
  constructor( public firstname: string,
               public lastname: string,
               public username: string,
               public password: string
  ){}
}

export class ValidateCures
{
  constructor( public allergicCures: Cure[],
               public allergicIngredients: Ingredient[]
  ){}
}

export class User
{
  constructor( public id: number,
               public firstname: string,
               public lastname: string,
               public username: string,
               public password: string

  ){}
}






