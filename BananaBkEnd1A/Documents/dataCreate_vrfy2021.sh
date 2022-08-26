# Web ApiKey Generate
curl --header "Content-Type: application/json" --request POST --data '{}' http://127.0.0.1:8020/ba/6l3AQeyhgQwedGW2vVSSBjkj2H2jmm2mbVhaBsKSLjw2NSazanqqs/
# Mobile ApiKey Generate
curl --header "Content-Type: application/json" --request POST --data '{}' http://127.0.0.1:8020/ba/sJWk4jFd23cskhw6iqu1d8Q2wetgFuy343qwSd71rt23feq671/
# Validate user Phone
curl --header "Content-Type: application/json" --request POST --data '{"p2":"1122","p3":"100"}' http://127.0.0.1:8020/ba/kK324h34gv6upopsbc2378av278sad738bvqv67svkerntpt/AxJezeKdNGbashsVw0vmjMThS5Pnxz
# Validate user Email
curl --header "Content-Type: application/json" --request POST --data '{"p1":"aa","p3":"100"}' http://127.0.0.1:8020/ba/ncsiow22uiANSX2klsaLAKskj2KSJd546kt1j21k/AxJezeKdNGbashsVw0vmjMThS5Pnxz

# Retrieve Ads list in pages 
curl --header "Content-Type: application/json" --request POST --data '{"p1":"1","p2":"noida","p3":",4,","p4":",1,"}' http://127.0.0.1:8020/ba/wqedw2FRT3dndi33io4jirU3jr3ojw621223nn/HussaxbZ0NeI5C75eRyh70Alt5s1vz
#get all category for Mobile
curl --header "Content-Type: application/json" --request POST --data '{"p1":"1","p2":"en"}' http://127.0.0.1:8020/ba/aMEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f/dobVdW8sbdxF1SzqqJZ7XHXq3lX8bb
#get all category for Web
curl --header "Content-Type: application/json" --request POST --data '{"p1":"1","p2":"en"}' http://127.0.0.1:8020/ba/aMEsTRHvTYd213YUJen23dRT3nRTruRT48bfTR56gT45nTHiTYgJ8Uw3wifq283f/lx57itJAB8ld3TUEEod3GdglKemnde
#get OwnerSeeHisOwnAds by phone number
curl --header "Content-Type: application/json" --request POST --data '{"p2":"2","p3":"3"}' http://127.0.0.1:8020/ba/a4qaSDfgVMscaw343jd32d322asdJKA3jd/lx57itJAB8ld3TUEEod3GdglKemnde


#get OwnerSeeHisOwnAds by ownerId
curl --header "Content-Type: application/json" --request POST --data '{"p1":"ewedwe2342wmbbvs2q32gs"}' http://127.0.0.1:8020/ba/Bkjedkfjsoiwenbs232DF4ishd62FDH45652uvds5SD62Klvdas56ytcETGd/
##Verified Classes
CategoryController
WebLoginController
RetrieveAdsController
OwnerListAds



###ToDo Web
MyLiked Ads on Web
Category List on new Page in Web
####ToDo Mobile
Change LikedAds image

###
Login from Web
curl --header "Content-Type: application/json" --request POST --data '{"p2":"1122","p3":"100"}' http://localhost:8020/ba/kK324h34gv6upopsbc2378av278sad738bvqv67svkerntpt/2dniKcmvbMxEseDelAxqntiOqdSDsO





















