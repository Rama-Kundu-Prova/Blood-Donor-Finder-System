

       function selectDistrict(s1,s2)
        {
            var s1=document.getElementById(s1);
            var s2=document.getElementById(s2);

            s2.innerHTML= "";

            if(s1.value=="Barishal")
            {
                var optionArray=['choose|Choose District','Barguna|Barguna','Barishal|Barishal','Bhola|Bhola','Jhalokati|Jhalokati','Patuakhali|Patuakhali','Pirojpur|Pirojpur'];
            }
            else if(s1.value =="Chittagong"){
                var optionArray=['choose|Choose District','Bandarban|Bandarban','Brahmanbaria|Brahmanbaria','Chandpur|Chandpur','Chattogram|Chattogram','Cumilla|Cumilla',
                'Cox Bazar|Cox Bazar','Feni|Feni','Khagrachhari|Khagrachhari','Lakshmipur|Lakshmipur','Noakhali|Noakhali','Rangamati|Rangamati'];
            }
            else if(s1.value=='Dhaka')
            {
                var optionArray=['choose|Choose District','Dhaka|Dhaka','Faridpur|Faridpur','Gazipur|Gazipur','Gopalganj|Gopalganj','Kishoreganj|Kishoreganj',
                'Madaripur|Madaripur','Manikganj|Manikganj','Munshiganj|Munshiganj','Narayanganj|Narayanganj','Narsingdi|Narsingdi','Rajbari|Rajbari',
                'Shariatpur|Shariatpur','Tangail|Tangail'];

            }
              else if(s1.value=='Khulna')
            {
                var optionArray=['choose|Choose District','Bagerhat|Bagerhat','Chuadanga|Chuadanga','Jashore|Jashore','Jhenaidah|Jhenaidah','Khulna|Khulna',
                'Kushtia|Kushtia','Magura|Magura','Meherpur|Meherpur','Narail|Narail','Satkhira|Satkhira'];

            }
             
             else if(s1.value=='Mymensingh')
            {
                var optionArray=['choose|Choose District','Jamalpur|Jamalpur','Mymensingh|Mymensingh','Netrokona|Netrokona','Sherpur|Sherpur'];
            }
            
             else if(s1.value=='Rajshahi')
            {
		
                var optionArray=['choose|Choose District','Bogura|Bogura','Joypurhat|Joypurhat','Naogaon|Naogaon','Natore|Natore','Chapai Nawabganj|Chapai Nawabganj',
                'Pabna|Pabna','Rajshahi|Rajshahi','Sirajganj|Sirajganj'];

            }
             else if(s1.value=='Rangpur')
            {
		
                var optionArray=['choose|Choose District','Dinajpur|Dinajpur','Gaibandha|Gaibandha','Kurigram|Kurigram','Lalmonirhat|Lalmonirhat','Nilphamari|Nilphamari',
                'Panchagarh|Panchagarh','Rangpur|Rangpur','Thakurgaon|Thakurgaon'];

            }
             else if(s1.value=='Sylhet')
            {
                var optionArray=['choose|Choose District','Habiganj|Habiganj','Moulvibazar|Moulvibazar','Sunamganj|Sunamganj','Sylhet|Sylhet'];

            }
            

            for(var option in optionArray)
            {
                var pair =optionArray[option].split("|");
                var newoption = document.createElement("option");
                newoption.value=pair[0];
                newoption.innerHTML=pair[1];
                s2.options.add(newoption);
            }


        }

        function selectThana(s1,s2)
        {
            var s1=document.getElementById(s1);
            var s2=document.getElementById(s2);

            s2.innerHTML= "";
            

 

            
            if(s1.value=="Dhaka")
            {
                var optionArray=['choose|Choose Thana/Upozila','Adabar Thana|Adabar Thana','Badda Thana|Badda Thana ','Bangshal Thana|Bangshal Thana','bhashantekThana|Bhashantek Thana ','Bhatara Thana|Bhatara Thana',
                'Biman Bandar Thana|Biman Bandar Thana ','Cantonment Thana|Cantonment Thana ','Chalkbazar Thana|Chalkbazar Thana ','Dakhinkhan Thana|Dakhinkhan Thana ','Darus Salam Thana|Darus Salam Thana','Demra Thana|Demra Thana ',
                'Dhamrai Upazila|Dhamrai Upazila','Dhanmondi Thana|Dhanmondi Thana','Dohar Upazila |Dohar Upazila ',
                'Gendaria Thana|Gendaria Thana','Gulshan Thana|Gulshan Thana ',
                'Hazaribagh Thana|Hazaribagh Thana','JatrabariThana|Jatrabari Thana ',
                'Kadamtoli Thana|Kadamtoli Thana','Kafrul Thana|Kafrul Thana',
                'Savar Upazila|Savar Upazila'];
            }
            else if(s1.value =="b"){
                var optionArray=['xx|XX','yy|YY','zz|ZZ'];
            }
            else if(s1.value =="c"){
                var optionArray=['ppp|PPP','qqq|QQQ','rrr|RRR'];
            }

            for(var option in optionArray)
            {
                var pair =optionArray[option].split("|");
                var newoption = document.createElement("option");
                newoption.value=pair[0];
                newoption.innerHTML=pair[1];
                s2.options.add(newoption);
            }

        }

        function selectUnion(s1,s2)
        {
            var s1=document.getElementById(s1);
            var s2=document.getElementById(s2);

            s2.innerHTML= "";
            
            if(s1.value=="Savar Upazila")
            {
                var optionArray=['choose|Choose Union','Aminbazar|Aminbazar','Ashulia|Ashulia ','Birulia|Birulia','Bongaon|Bongaon ','Dhamsona|Dhamsona',
                'Kaundia|Kaundia ','Pathalia|Pathalia ','Savar|Savar ','Shimulia|Shimulia','Tetuljhora|Tetuljhora','Vakurta|Vakurta',
                'Yearpur|Yearpur'];
            }
         
            else if(s1.value =="Dhamrai Upazila"){
                 var optionArray=['choose|Choose Union','Amta|Amta','Baisakanda|Baisakanda ','Balia|Balia','Bhararia|Bhararia ','Chauhati|Chauhati',
                'Dhamrai|Dhamrai','Gangutia|Gangutia ','Jadabpur|Jadabpur ','Kulla|Kulla','Kushura|Kushura','Nannar|Nannar',
                'Rowail|Rowail','Sanora|Sanora ','Sombhag|Sombhag ','Suapur|Suapur','Sutipara|Sutipara'];
            }

            for(var option in optionArray)
            {
                var pair =optionArray[option].split("|");
                var newoption = document.createElement("option");
                newoption.value=pair[0];
                newoption.innerHTML=pair[1];
                s2.options.add(newoption);
            }


        }


    