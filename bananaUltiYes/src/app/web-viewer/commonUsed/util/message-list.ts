export class MessageList_cl {
    httpCodes_vb: {[key_vb: string]: string};
    adType_vb: {[key_vb: string]: string};
    status_vb: {[key_vb: string]: string};
    constructor( ) {
        this.httpCodes_vb= {
            '0': "Press F5. Check Internet Connection", 
            '1': "no_more_results_msg",

            '2': "no_result_found_msg",
            '304': "Please try after sometime",                      
        }        
        this.adType_vb= {
             '1':'12 Hours Ad',
             '2':'1 Week Ad',
             '3':'1 Month Ad',
             '4':'1 Year Ad'
        }
        this.status_vb= {
            'Y':'Yes',
            'N':'Not Active',
            '3':'Not Active',
            '4':'Not Active'
       }
    }
}

/*
Usage:

var indexedArray: {[key: string]: number} = {
    foo: 2118,
    bar: 2118
}

indexedArray['foo'] = 2118;
indexedArray.foo= 2118;

let foo = indexedArray['myKey'];
let bar = indexedArray.myKey;

*/
