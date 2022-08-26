export class ResponseSuccess_cl {
    message_vb: string;
    status_vb: string;
    p1:string;p2:string;p3:string;
    constructor( message_vb: string, status_vb: string,p1:string,p2:string,p3:string) {
        this.message_vb = message_vb;
        this.status_vb = status_vb;
        this.p1=p1;

        this.p2=p2;
        this.p3=p3;
    }
}