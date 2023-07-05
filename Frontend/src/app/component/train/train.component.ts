import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Train } from '../../model/train';
import { TrainService } from '../../service/train.service';

@Component({
  selector: 'app-train',
  templateUrl: './train.component.html',
  styleUrls: ['./train.component.css']
})

export class TrainComponent implements OnInit {  
  trainForm!: FormGroup; 
  searchByNumberForm: FormGroup;
  searchByNameForm: FormGroup;  
  searchBySeatsAvalForm: FormGroup;

  showAdd!:boolean;
  showUpdate!:boolean;

  trains!: Train[] ;
  currentTrain!:Train;

  // searchResult!: Train;
  searchResult: any[];
  searchResultObj:any;

  constructor(private formBuilder: FormBuilder,private trainService: TrainService) { 

    this.searchResult = [];

    this.searchByNumberForm = this.formBuilder.group({
      number: ['', Validators.required]
    });

    this.searchByNameForm = this.formBuilder.group({
      name: ['', Validators.required]
    });

    this.searchBySeatsAvalForm = this.formBuilder.group({
      seats: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.trainForm = this.formBuilder.group({
      id:[''],
      number: ['', Validators.required],
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      departureStation: ['', Validators.required],
      departureTime: ['', Validators.required],
      arrivalStation: ['', Validators.required],
      arrivalTime: ['', Validators.required],
      duration: ['', Validators.required],
      distance: ['', Validators.required],
      fare: [''],
      seatsAvailable: ['']
    });
    this.showAdd= true;
    this.getAllTrains();
  }

  getAllTrains(): void {
    this.trainService.getAllTrains().subscribe(
      (trains: Train[]) => {
        this.trains = trains;
      }
    );
  }


  //not using in this app
  getTrainById(id: number): void {
    this.trainService.getTrainById(id).subscribe(
      (train: Train) => {
        this.currentTrain = train;
        this.trainForm.patchValue(train);
        //console.log('Train:', train);
      }
      // ,
      // (error) => {
      //   console.error('Error:', error);
      // }
    );
  }
  

  createTrain(): void {
    this.showAdd=true;
    this.showUpdate=false;
    if (this.trainForm.invalid) {
      return;
    }

    const product: Train = {
      id: null,
      ...this.trainForm.value
    };

    this.trainService.createTrain(product).subscribe(
      (newTrain: Train) => {
        this.trainForm.reset();
        this.getAllTrains();
      }
 
    );
  }

  editTrain(train:any){
    this.showAdd= false;
    this.showUpdate=true;
    this.trainForm.controls['id'].setValue(train.id);
    this.trainForm.controls['number'].setValue(train.number);
    this.trainForm.controls['name'].setValue(train.name);
    this.trainForm.controls['departureStation'].setValue(train.departureStation);
    this.trainForm.controls['departureTime'].setValue(train.departureTime);
    this.trainForm.controls['arrivalStation'].setValue(train.arrivalStation);  
    this.trainForm.controls['arrivalTime'].setValue(train.arrivalTime);
    this.trainForm.controls['duration'].setValue(train.duration);
    this.trainForm.controls['distance'].setValue(train.distance);
    this.trainForm.controls['fare'].setValue(train.fare);
    this.trainForm.controls['seatsAvailable'].setValue(train.seatsAvailable);
   } 

  updateTrain(train: Train): void {
    this.trainService.updateTrain(train).subscribe(
      () => {
        this.trainForm.reset();
        this.getAllTrains();
      } 
    );
  }

  deleteTrain(id: number): void {   
    this.trainService.deleteTrain(id).subscribe(
      () => {
        // console.log('Train deleted successfully');
        this.getAllTrains();
      } 
    );
  }
  

//search :returns an obj
  searchByNumber(): void {
    if (this.searchByNumberForm.valid) {
      const number = this.searchByNumberForm.value.number;
      this.trainService.getTrainByNumber(number).subscribe((train: any) => {
        this.searchResultObj = train;
        this.searchByNumberForm.reset();
      });
    }
  }

//search :returns an array
   searchByName(): void {
    if (this.searchByNameForm.valid) {
      const name = this.searchByNameForm.value.name;
      this.trainService.getTrainsByName(name).subscribe((train: any) => {
        this.searchResult = train;
        this.searchByNameForm.reset();
      });
    }
  }

//search :returns an array
  searchBySeatsAvailable(): void {
    if (this.searchBySeatsAvalForm.valid) {
      const seats = this.searchBySeatsAvalForm.value.seats;
      this.trainService.getTrainsBySeatsAvailable(seats).subscribe((train: any) => {
        this.searchResult = train;
        this.searchBySeatsAvalForm.reset();
      });
    }
  }


}
