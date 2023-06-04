import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable, MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { ColoniesService } from './colonies.service';
import { Colonie } from './colonie';
import { Observable } from 'rxjs';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ConfirmDialogComponent, ConfirmDialogModel } from '../confirm-dialog/confirm-dialog.component';
import { MatTableDataSource } from '@angular/material/table';
import { ColoniesDialogComponent } from './colonie-dialog/colonie-dialog.component';

@Component({
  selector: 'app-colonies',
  templateUrl: './colonies.component.html',
  styleUrls: ['./colonies.component.scss']
})
export class ColoniesComponent implements OnInit {
  displayedColumns: string[] = ['name', 'availability', 'extensionsNumber', 'action'];

  @ViewChild(MatTable) table!: MatTable<Colonie>;
  dataSource = new MatTableDataSource<Colonie>();

  constructor(private colnySrv: ColoniesService, public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.updateDatasource();
  }

  updateDatasource() {
    this.colnySrv.getColonies().subscribe(data => this.dataSource.data = data);
  }

  resolveColonyDialog(dialogRef: MatDialogRef<ColoniesDialogComponent, Colonie>) {
    dialogRef.afterClosed().subscribe(result => {
      console.log('resolveColonyDialog:', result);

      if (result) {
        this.updateDatasource();
      }
    });

  }

  addData() {
    const dialogRef = this.dialog.open(ColoniesDialogComponent, {
      data: {},
    });

    this.resolveColonyDialog(dialogRef);
  }

  editData(row: Colonie) {
    const dialogRef = this.dialog.open(ColoniesDialogComponent, {
      data: row,
    });

    this.resolveColonyDialog(dialogRef);
  }

  deleteData(row: Colonie) {
    console.log('deleteData:', row);

    const message = `Smazat kolonii ${row.name}?`;
    const dialogData = new ConfirmDialogModel("Potvrzení mazání kolonie", message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.colnySrv.deleteColony(row.name).subscribe({
          next: value => {
            console.log('Data byla smazána', value);
            this.updateDatasource();
         },
          error: err => console.error('Data se nepodařilo smazat:', err),
          complete: () => console.log('Zpracování bylo dojkončeno'),
        });
      } else {
        console.log('Nebude se mazat');
      }
    });
  }
}
