export class MyAdsDto_cl {
    id_vb: string;
    adType_vb: string;
    adDisplayType_vb: string;
    contentDesc_vb: string;
    createdOn_vb: string;
    activeDate_vb: string;
    status_vb:string;
    imageToShow_vb: any; 
    p1:string; p2:string; p3:string; p4:string; p5:string; p6:string; p7:string; p10:string; 

    constructor(id_vb: string, adType_vb: string, uploadedFileName_vb: string,contentDesc_vb: string,
         createdOn_vb: string, inputFile01_vb: Blob) {
        this.id_vb = id_vb;
        this.adType_vb = adType_vb;
        this.contentDesc_vb = contentDesc_vb;
        this.createdOn_vb = createdOn_vb;
        
    }
}
