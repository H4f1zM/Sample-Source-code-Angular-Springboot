angular.module("ManagePatientAppApplication").controller("GeneralController", GeneralController);

GeneralController.inject = [ '$scope', 'Patient' ];

function GeneralController($scope, Patient) {
	
	$scope.patients = Patient.query();

	$scope.patient = {};
	
	$scope.buttonText="Submit";
	
	$scope.savePatient = function() {
		
		if ($scope.patient.id !== undefined) {  // update data patient 
				
			Patient.update($scope.patient, function() {
				$scope.patient = {};
				$scope.buttonText="Submit";
				$scope.patients = Patient.query();

				

			});
			
		} else {  // save new data patient 
			
			Patient.save($scope.patient, function() {
				
				$scope.patients = Patient.query();
				$scope.patient = {};

			});
		}
	}

	$scope.updatePatientInit = function(patient) {
		$scope.buttonText="Update";
		$scope.patient = patient;
	}

	$scope.deletePatient = function(patient) {
		
		alert("delete patient with id = " + patient.id );
		
		
		Patient.delete(patient.id, function() {
			alert("masuk function delete patient ");
			$scope.patients = Patient.query();
		});
		
	}
	

	
	

	
}