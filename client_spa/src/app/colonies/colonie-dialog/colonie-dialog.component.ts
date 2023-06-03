import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Colonie } from '../colonie';
import { ColoniesService } from '../colonies.service';

@Component({
  selector: 'app-colonie-dialog',
  templateUrl: './colonie-dialog.component.html',
  styleUrls: ['./colonie-dialog.component.scss']
})
export class ColoniesDialogComponent {
  dialogTitle: string;
  updateDate: boolean;
  errMsg = '';

  constructor(
              public dialogRef: MatDialogRef<ColoniesDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Colonie,
              private colnySrv: ColoniesService) {

      this.updateDate = !!data?.name;
      this.dialogTitle = this.updateDate ? `Úprava kolonie ${data.name}` : 'Nová kolonie';

      dialogRef.disableClose = true;
    }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSave() {
    const restAction = this.updateDate ? this.colnySrv.upddate(this.data) : this.colnySrv.create(this.data);

    restAction.subscribe({
      next: value => {
        console.log('Data byla aktualizována', value);
        this.dialogRef.close(this.data);
     },
      error: err => {
        console.error('Nepodařilo se uložit data:', this.data, err);
        this.errMsg = err.message;
    },
      complete: () => console.log('Zpracování bylo dojkončeno'),
    })




  }
}
