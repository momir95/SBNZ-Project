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
               public cures: Cure[],
               public disease: Disease,
               public symptoms: Symptom[]
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
              public ingredients: Ingredient[]
  ) {}
}

export class Disease
{
  constructor( public id:number,
               public name: string,
               public symptoms: Symptom[]
  ) {}
}

export class Symptom
{
  constructor( public id:number,
               public name: string
  ) {}
}

export class Ingredient
{
  constructor( public id:number,
               public name: string
  ) {}
}






