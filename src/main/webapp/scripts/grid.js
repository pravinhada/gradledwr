Ext.onReady(function() {
	Ext.QuickTips.init();

	Ext.define('Provider', {
		extend : 'Ext.data.Model',
		fields : [ 'providerId', 'providerName' ],
		proxy : {
			type : 'dwr',
			// assume that we have dwr function getTestGrid(storeParameters
			// a,Integer b,Integer c)
			// first one goes automatically it includes start,limit,page and
			// other store parameters
			// second and third are optional we pass them through dwrParams as
			// an array
			dwrFunction : Providers.getAllProviders,
			dwrParams : [],
			reader : {
				type : 'json',
				root : 'data',
				totalProperty : 'totalCount'
			}
		}
	});

	var store = Ext.create('Ext.data.Store', {
		requiers : [ 'Ext.data.DWRProxy' ],
		model : 'Provider'
	});

	// grid for the Provider data
	var dataGrid = Ext.create('Ext.grid.Panel', {
		store : store,
		columns : [ {
			header : 'Provider Id',
			dataIndex : 'providerId',
			flex : 1
		}, {
			header : 'Provider Name',
			dataIndex : 'providerName',
			flex : 1
		} ],
		renderTo : 'grid-example',
		height : 500,
		width : 800,
		title : 'Provider',
		viewConfig : {
			stripRows : true
		}
	});

	store.load();
});