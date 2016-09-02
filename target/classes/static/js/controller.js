
app.controller('PersonInfoController', function ($scope, $http, $location) {
    $scope.headingTitle = "Candidates List";

    var self = this;
    self.candidate={nom:'',prenom:'',phone:'',specialiste:''};
    self.newRdv = {id:'',nom:'',prenom:'',phone:'',specialiste:'',rdv:''};
    //self.candidates=[];

    self.submit = submit;
    self.remove = remove;
    self.reset = reset;
    self.changeStatusRDV = changeStatusRDV;
    self.makeCall = makeCall;

    //exposer les methodes et variables


    function init(){

        //$http.get("http://ospieafrpf.cluster006.ovh.net/JavCha/php/question/ws/QuestionWs.php")
        //$http.get("http://localhost:63342/JavCha/php/question/ws/QuestionWs.php")
        $http.get("/candidates")
            .success(function(response) {
                self.candidates=response;
            });

        $http.get("/specialistes")
            .success(function(response) {
                self.specialistes=response;
            });
    }

    init();

    function submit() {

        self.candidate={nom:self.candidate.nom,prenom:self.candidate.prenom,phone:self.candidate.phone,specialiste:self.candidate.specialiste};
        $http.post('/save',self.candidate)
            .success(function (data,status,headers,config) {
                console.log("candidate saved.");
                init();
            });
        reset();
    }

    function remove(candidate){
        /*console.log('id to be deleted', id);
        if(self.candidate.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }*/
        $http.post('/delect',candidate)
            .success(function (data,status,headers,config){
                console.log("candidate removed");
                init();
        });
    }


    function changeStatusRDV(candidate){

        if(candidate.rdv == "No") {
            self.newRdv = {id: candidate.id, nom: candidate.nom, prenom: candidate.prenom, phone: candidate.phone, specialiste: candidate.specialiste, rdv: "Yes"};
        }
        else if(candidate.rdv == "Yes"){
            self.newRdv = {id: candidate.id, nom: candidate.nom, prenom: candidate.prenom, phone: candidate.phone, specialiste: candidate.specialiste, rdv: "No"};
        }
        console.log(self.newRdv);
        $http.post('/update',self.newRdv)
            .success(function(data,status,headers,config){
                console.log("rdv changed");
                init();
            });
    }


    function reset(){
        self.candidate={nom:'',prenom:'',phone:'',specialiste:''};
        $scope.myForm.$setPristine(); //reset Form
    }

    function makeCall(candidate){
        $http.post('/callCandidate',candidate)
            .success(function (data,status,headers,config){
                console.log("candidate called");
                init();
            });
    }

});