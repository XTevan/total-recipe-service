#!/bin/sh
curl -X POST "http://localhost:8080/recipe" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 1, \"name\": \"Cookie\", \"createdAt\": \"2018-07-28\", \"imagePath\": \"https://www.voedingsadviesbureau-puur.nl/wp-content/uploads/2018/06/cookie-wet.jpg\", \"portionSize\": 2, \"ingredients\": [ \"wheat flower\",{\"qty\":1, \"unit\":\"cup\",\"ingredient_name\":\"chocolate flower\"} , \"milk\", \"butter\" ], \"instructions\": [ \"mix everything\", \"cook\" ], \"vegetarian\": false }"
curl -X POST "http://localhost:8080/recipe" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 2, \"name\": \"Risotto Parmesan\", \"createdAt\": \"2018-07-28\", \"imagePath\": \"https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/2/24/2/BX0605H_easy-parmesan-risotto_s4x3.jpg.rend.hgtvcom.826.620.suffix/1406090695131.jpeg\", \"portionSize\": 2, \"ingredients\": [ \"onion\", \"white wine\", \"rice\", \"butter\", \"parmesan cheese\", \"palmtree\" ], \"instructions\": [ \"mix everything\", \"cook\" ], \"vegetarian\": true }"
curl -X POST "http://localhost:8080/recipe" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 3, \"name\": \"Chipotle's Chicken\", \"createdAt\": \"2018-07-29\", \"imagePath\": \"https://img.buzzfeed.com/thumbnailer-prod-us-east-1/2493053d262844febf4ba930f24509c7/FB_FINAL.jpg\", \"portionSize\": 1, \"ingredients\": [ \"1 lb (455 g) boneless, skinless chicken thighs\", \"kosher salt, to taste\", \"freshly ground black pepper, to taste\", \"6 oz (170 g) chipotle pepper in adobo sauce, 1/2 can, finely chopped\", \"1 tablespoon vegetable oil\" ], \"instructions\": [ \"On a cutting board, season the chicken all over with salt and pepper.\", \"Transfer the chicken to a large zip-top bag with the chopped chipotles and mix until the chicken is fully coated.\", \"Refrigerate for at least 2 hours, up to overnight.\", \"Heat the oil in a large skillet over medium-high heat.\", \"Add the chicken and cook until golden brown, 4 minutes per side.\", \"Remove the chicken with tongs and place on a cutting board. Let cool for 5 minutes. Cut the chicken into bite-sized pieces.\", \"Transfer the chicken back to the pan over medium-high heat and cook, stirring frequently, for 2-3 minutes, until all pieces are browned.\", \"Enjoy!\" ], \"vegetarian\": false }"
curl -X POST "http://localhost:8080/recipe" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 4, \"name\": \"Bread\", \"createdAt\": \"2018-07-30\", \"imagePath\": \"https://d2gk7xgygi98cy.cloudfront.net/5643-3-large.jpg\", \"portionSize\": 2, \"ingredients\": [ { \"quantity\": 1, \"unit\": \"cup\", \"name\": \"wheat flower\" }, { \"spoon\": 1, \"name\": \"butter\" }, { \"quantity\": 1, \"unit\": \"cup\", \"ingredient\": \"milk\" }, { \"quantity\": 3, \"name\": \"eggs\" } ], \"instructions\": [ \"mix everything\", \"bake\" ], \"vegetarian\": true }"