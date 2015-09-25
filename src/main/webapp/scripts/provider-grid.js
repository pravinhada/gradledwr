Ext.onReady(function() {
	Ext.QuickTips.init();

	var reader = new Ext.data.JsonReader({
		root : 'objectsToConvertToRecords',
		fields : [ {
			name : 'providerId',
			allowBlank : false
		}, {
			name : 'providerName',
			allowBlank : false
		}, {
			name : 'status'
		}, {
			name : 'emailConfirmation'
		}, {
			name : 'dateAdded',
			type : 'date'
		} ]
	});

	var writer = new Ext.data.JsonWriter({
		writeAllFields : true,
		listful : true
	});

	// Setup the store for the grid. This store uses DwrProxy.
	// The reader is JsonReader, thus the DWR function has to return an object
	// that has an array of record data.
	var store = new Ext.data.Store({
		proxy : new Ext.ux.data.DwrProxy({
			apiActionToHandlerMap : {
				read : {
					dwrFunction : Providers.getAllProviders
				}
			}
		}),
		reader : reader,
		writer : writer,
		autoLoad : true,
		autoSave : true
	});

	// Define the grid to display the store's data.
	var grid = new Ext.grid.GridPanel({
		store : store,
		columns : [ {
			header : "Provider Id",
			width : 160,
			sortable : true,
			dataIndex : 'providerId'
		}, {
			header : "Provider Name",
			width : 350,
			sortable : true,
			dataIndex : 'providerName'
		}, {
			header : "Status",
			width : 160,
			sortable : true,
			dataIndex : 'status'
		}, {
			header : "Email",
			width : 160,
			sortable : true,
			dataIndex : 'emailConfirmation'
		}, {
			header : "Date Added",
			width : 160,
			sortable : true,
			dataIndex : 'dateAdded',
			format : 'm/d/Y',
			renderer : Ext.util.Format.dateRenderer('m/d/Y')
		} ],
		stripeRows : true,
		height : 400,
		width : 1000,
		title : 'Provider',
		frame : true,
		loadMask : true,
		viewConfig : {
			forceFit : true
		},
		autoScroll : true,
		renderTo : 'grid-example',
	});
});