angular.module('ManagePatientAppApplication').factory('Patient', Patient);

Patient.$inject = [ '$resource' ];

function Patient($resource) {
	var resourceUrl = 'api/patient/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}