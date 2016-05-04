NOTE: service use hsqldb and store database in memory. If you use http://wildfly-yalek.rhcloud.com , the datastorage is not stable and clear all data after some time.
The OpenShift `jbossas` cartridge documentation can be found at:
https://github.com/openshift/origin-server/tree/master/cartridges/openshift-origin-cartridge-jbossas/README.md

GET:
     /users
Example: http://wildfly-yalek.rhcloud.com/users
Response: [{"mId":1,"mUserName":"Vasya","mUserLastName":"Pupkin","mUserAdress":"Ukraine, Kiev, st BigSreat","mShops":[{"mId":3,"mShopName":"SuperCars","mShopImgUri":"uri shop Cars","mShopLonCoord":"30.5234","mShopLatCoord":"50.4501"},{"mId":1,"mShopName":"FakeShop","mShopImgUri":"uri fake shop img","mShopLonCoord":"32.5234","mShopLatCoord":"51.4501"}]},{"mId":2,"mUserName":"SomeName","mUserLastName":"SomeLastName","mUserAdress":"Ukraine, Zhitomir, st BiggestSreat","mShops":[{"mId":2,"mShopName":"FlowerShop","mShopImgUri":"uri flowerShop","mShopLonCoord":"25.5234","mShopLatCoord":"70.4501"}]}]

GET:
	/users/{userId}
Example: http://wildfly-yalek.rhcloud.com/users/2
Response: {"mId":2,"mUserName":"SomeName","mUserLastName":"SomeLastName","mUserAdress":"Ukraine, Zhitomir, st BiggestSreat","mShops":[{"mId":2,"mShopName":"FlowerShop","mShopImgUri":"uri flowerShop","mShopLonCoord":"25.5234","mShopLatCoord":"70.4501"}]}

Get: 
	/users/{userId}/shops/{shopId}
Example:http://wildfly-yalek.rhcloud.com/users/1/shops/1
Response:{"mId":1,"mShopName":"FakeShop","mShopImgUri":"uri fake shop img","mShopLonCoord":"32.5234","mShopLatCoord":"51.4501"}

PUT:
	/users/{userId}
Example:http://wildfly-yalek.rhcloud.com/users/2  Body: {"mUserName":"NewName","mUserLastName":"New LastName","mUserAdress":"Ukraine, Zhitomir, st BiggestSreat"}

POST: /users
Example:http://wildfly-yalek.rhcloud.com/users/1/shops  Body {"mShopName":"SuperCars2","mShopImgUri":"uri shop Cars2","mShopLonCoord":"30.5234","mShopLatCoord":"50.4501"}

POST: /users/{userId}/shops
http://wildfly-yalek.rhcloud.com/users/1/shops Body {"mShopName":"FakeShop","mShopImgUri":"uri fake shop img","mShopLonCoord":"32.5234","mShopLatCoord":"51.4501"}
DELETE : /users/{userId}

