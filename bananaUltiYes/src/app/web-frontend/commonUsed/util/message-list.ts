export class MessageList_cl {
    httpCodes_vb: {[key_vb: string]: string};
    adType_vb: {[key_vb: string]: string};
    status_vb: {[key_vb: string]: string};
    constructor( ) {
        this.httpCodes_vb= {
            'msg_refresh': "Press F5. Check Internet Connection", 
            'msg_ok': "Ok",
            'msg_bad': "Bad request",
            'usr_not_found': "User not Found. Please check Phone/Email and Secret Number.",
            'file_not_acc': "File not accepted",
            'chk_phn_eml': "User not Found. Please check Phone/Email and Secret Number.",
            'store_fail': "Unable to store content. Please retry again. or Call Us",            
            'size_heavy': "File size should be less than 10L Bytes (1 MB).",
            'limit_reach': "Limit reached, Please modify one of your ads.",
            'trgt_stored' : "Target Area stored.",
            'modify_done': "Ad modify done",
            'file_upld_done': "File upload done. Please confirm 'Target Area'.",

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
