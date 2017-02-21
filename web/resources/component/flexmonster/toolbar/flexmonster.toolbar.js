/**
 * 	Toolbar for Flexmonster Pivot Table & Charts Component
 *	Version 2.3
 **/
var FlexmonsterToolbar = function(pivotContainer, pivot, _, width, labels) {
	var self = this;

	var isIOS = navigator.userAgent.match(/iPhone|iPad|iPod/i) || navigator.platform.match(/iPhone|iPad|iPod/i) ? true : false;
	var isMac = /Mac/i.test(navigator.platform);
	var isAndroid = navigator.userAgent.match(/Android/i) ? true : false;
	var isBlackBerry = /BlackBerry/i.test(navigator.platform);
	var isMobile = isIOS || isAndroid || isBlackBerry;
	var isMultipleValuesDissabled = false;
	var Labels = labels;
	
	if (typeof width == "number" || (width.indexOf("px") < 0 && width.indexOf("%") < 0)) {
		width += "px";
	}

	self.updateLabels = function (labels) {
	    Labels = labels;

	    self.setText(document.querySelector("#fm-tab-connect > a > span"), Labels.connect);
	    self.setText(document.querySelector("#fm-tab-connect-local-csv > a > span"), Labels.connect_local_csv);
	    self.setText(document.querySelector("#fm-tab-connect-local-json > a > span"), Labels.connect_local_json);
	    self.setText(document.querySelector("#fm-tab-connect-remote-csv > a > span"), isMobile ? Labels.connect_remote_csv_mobile : Labels.connect_remote_csv);
	    self.setText(document.querySelector("#fm-tab-connect-olap > a > span"), isMobile ? Labels.connect_olap_mobile : Labels.connect_olap);
        
	    self.setText(document.querySelector("#fm-tab-open > a > span"), Labels.open);
	    self.setText(document.querySelector("#fm-tab-open-local-report > a > span"), Labels.local_report);
	    self.setText(document.querySelector("#fm-tab-open-remote-report > a > span"), isMobile ? Labels.remote_report_mobile : Labels.remote_report);

	    self.setText(document.querySelector("#fm-tab-save > a > span"), Labels.save);

	    self.setText(document.querySelector("#fm-tab-grid > a > span"), Labels.grid);

	    self.setText(document.querySelector("#fm-tab-charts > a > span"), Labels.charts);
	    self.setText(document.querySelector("#fm-tab-charts-bar > a > span"), Labels.charts_bar);
	    self.setText(document.querySelector("#fm-tab-charts-line > a > span"), Labels.charts_line);
	    self.setText(document.querySelector("#fm-tab-charts-scatter > a > span"), Labels.charts_scatter);
	    self.setText(document.querySelector("#fm-tab-charts-pie > a > span"), Labels.charts_pie);
	    self.setText(document.querySelector("#fm-tab-charts-bar-stack > a > span"), Labels.charts_bar_stack);
	    self.setText(document.querySelector("#fm-tab-charts-bar-line > a > span"), Labels.charts_bar_line);
	    self.setText(document.querySelector("#fm-tab-charts-multiple > a > span"), Labels.charts_multiple);

	    self.setText(document.querySelector("#fm-tab-format > a > span"), Labels.format);
	    self.setText(document.querySelector("#fm-tab-format-cells > a > span"), Labels.format_cells_mobile);
	    self.setText(document.querySelector("#fm-tab-format-conditional > a > span"), Labels.conditional_formatting_mobile);

	    self.setText(document.querySelector("#fm-tab-options > a > span"), Labels.options);
	    self.setText(document.querySelector("#fm-tab-fullscreen > a > span"), Labels.fullscreen);

	    self.setText(document.querySelector("#fm-tab-export > a > span"), Labels.export);
	    self.setText(document.querySelector("#fm-tab-export-print > a > span"), Labels.export_print);
	    self.setText(document.querySelector("#fm-tab-export-html > a > span"), Labels.export_html);
	    self.setText(document.querySelector("#fm-tab-export-csv > a > span"), Labels.export_csv);
	    self.setText(document.querySelector("#fm-tab-export-excel > a > span"), Labels.export_excel);
	    self.setText(document.querySelector("#fm-tab-export-image > a > span"), Labels.export_image);
	    self.setText(document.querySelector("#fm-tab-export-pdf > a > span"), Labels.export_pdf);

	    self.setText(document.querySelector("#fm-tab-fields > a > span"), Labels.fields);
	}


	// TABS
	var dataProvider = [];
	// Connect tab
	dataProvider.push({ title: Labels.connect, id: "fm-tab-connect",
		menu: [
			{ title: Labels.connect_local_csv, id: "fm-tab-connect-local-csv", handler: "connectLocalCSVHandler", mobile: false },
			{ title: Labels.connect_local_json, id: "fm-tab-connect-local-json", handler: "connectLocalJSONHandler", mobile: false },
			{ title: isMobile ? Labels.connect_remote_csv_mobile : Labels.connect_remote_csv, id: "fm-tab-connect-remote-csv", handler: "connectRemoteCSV" },
			{ title: isMobile ? Labels.connect_olap_mobile : Labels.connect_olap, id: "fm-tab-connect-olap", handler: "connectOLAP", flat: false }
		]
	});

	// Open tab
	dataProvider.push({ title: Labels.open, id: "fm-tab-open", 
		menu: [
			{ title: Labels.local_report, id: "fm-tab-open-local-report", handler: "openLocalReport", mobile: false },
			{ title: isMobile ? Labels.remote_report_mobile : Labels.remote_report, id: "fm-tab-open-remote-report", handler: "openRemoteReport" }
		] 
	});
	
	// Save tab
	dataProvider.push({ title: Labels.save, id: "fm-tab-save", handler: "saveHandler", mobile: false });

	dataProvider.push({ divider: true });

	// Grid tab
	dataProvider.push({ title: Labels.grid, id: "fm-tab-grid", handler: "gridHandler" });

	// Charts tab
	dataProvider.push({ title: Labels.charts, id: "fm-tab-charts", onShowHandler: "checkChartMultipleMeasures",
		menu: [
			{ title: Labels.charts_bar, id: "fm-tab-charts-bar", handler: "chartsHandler", args: "bar" },
			{ title: Labels.charts_line, id: "fm-tab-charts-line", handler: "chartsHandler", args: "line" },
			{ title: Labels.charts_scatter, id: "fm-tab-charts-scatter", handler: "chartsHandler", args: "scatter" },
			{ title: Labels.charts_pie, id: "fm-tab-charts-pie", handler: "chartsHandler", args: "pie" },
			{ title: Labels.charts_bar_stack, id: "fm-tab-charts-bar-stack", handler: "chartsHandler", args: "bar_stack", flat: false },
			{ title: Labels.charts_bar_line, id: "fm-tab-charts-bar-line", handler: "chartsHandler", args: "bar_line", flat: false },
			{ divider: true, flat: false, mobile: false },
			{ title: Labels.charts_multiple, id: "fm-tab-charts-multiple", handler: "chartsMultipleHandler", flat: false, mobile: false }
		]
	});
	dataProvider.push({ divider: true });

	// Format tab
	dataProvider.push({ title: Labels.format, id: "fm-tab-format", 
		menu: [
			{ title: isMobile ? Labels.format_cells_mobile : Labels.format_cells, id: "fm-tab-format-cells", handler: "formatCellsHandler" },
			{ title: isMobile ? Labels.conditional_formatting_mobile : Labels.conditional_formatting, id: "fm-tab-format-conditional", handler: "conditionalFormattingHandler" }
		]
	});

	// Options tab
	dataProvider.push({ title: Labels.options, id: "fm-tab-options", handler: "optionsHandler" });

	// Right-aligned tabs should go in reversed order due to float: right

	// Fullscreen tab
	if (document["addEventListener"] != undefined) { // For IE8
		dataProvider.push({ title: Labels.fullscreen, id: "fm-tab-fullscreen", handler: "fullscreenHandler", mobile: false });
	}

	// Export tab
	dataProvider.push({ title: Labels.export, id: "fm-tab-export", mobile: false,
		menu: [
			{ title: Labels.export_print, id: "fm-tab-export-print", handler: "printHandler" },
			{ title: Labels.export_html, id: "fm-tab-export-html", handler: "exportHandler", args: "html" },
			{ title: Labels.export_csv, id: "fm-tab-export-csv", handler: "exportHandler", args: "csv" },
			{ title: Labels.export_excel, id: "fm-tab-export-excel", handler: "exportHandler", args: "excel" },
			{ title: Labels.export_image, id: "fm-tab-export-image", handler: "exportHandler", args: "image" },
			{ title: Labels.export_pdf, id: "fm-tab-export-pdf", handler: "exportHandler", args: "pdf" },
		]
	});

	// Fields tab
	dataProvider.push({ title: Labels.fields, id: "fm-tab-fields", handler: "fieldsHandler" });

	// HANDLERS

	// Connect tab
	self.connectLocalCSVHandler = function() {
		self.pivot.connectTo({ dataSourceType: "csv", browseForFile: true });
	}
	self.connectLocalJSONHandler = function() {
		self.pivot.connectTo({ dataSourceType: "json", browseForFile: true });
	}
	self.connectRemoteCSV = function() {
		self.showConnectToRemoteCSVDialog();
	}
	self.connectOLAP = function () {
		self.showConnectToOLAPDialog();
	}

	// Open tab
	self.openLocalReport = function() {
		self.pivot.open();
	}
	self.openRemoteReport = function() {
		self.showOpenRemoteReportDialog();
	}

	// Save tab
	self.saveHandler = function() {
		self.pivot.save("report.json", 'file');
	}

    ////Save JSON
	//self.saveJSONHandler = function () {
	//    self.pivot.saveJSON("report.js", 'file');
	//}

	// Grid tab
	self.gridHandler = function() {
	    self.pivot.showGrid();
	}

	// Charts tab
	self.chartsHandler = function (type) {
	    var options = self.pivot.getOptions() || {};
	    var multiple = options['chart']['multipleMeasures'];
	    var node = document.getElementById("fm-tab-charts-multiple");
	    if(node != null) self.disableMultyValues(type, multiple, node);
		self.pivot.showCharts(type, multiple);
	}
	self.chartsMultipleHandler = function () {
	    var options = self.pivot.getOptions() || {};
	    var type = options['chart']['type'];
	    var multiple = !options['chart']['multipleMeasures'];
	    var node = document.getElementById("fm-tab-charts-multiple");
	    multiple ? self.addClass(node, "fm-selected") : self.removeClass(node, "fm-selected");
	    if (type == "pie" || type == "bar_stack" || type == "bar_line") {
	        self.removeClass(node, "fm-selected");
	    } else self.pivot.showCharts(type, multiple);
	}
	self.checkChartMultipleMeasures = function () {
	    var options = self.pivot.getOptions() || {};
	    if (options === undefined) return;
		var multiple = options['chart']['multipleMeasures'];
		var node = document.getElementById("fm-tab-charts-multiple");
		if (node != null) self.disableMultyValues(options['chart']['type'], multiple, node);
	}

	self.disableMultyValues = function (type, multiple, node) {
	    if (type == "pie" || type == "bar_stack" || type == "bar_line") {
	        var chartType = "";
	        switch (type) {
	            case ("pie"):
	                chartType = Labels.charts_pie;
	                break;
	            case ("bar_stack"):
	                chartType = Labels.charts_bar_stack;
	                break;
	            case ("bar_line"):
	                chartType = Labels.charts_bar_line;
	                break;
	        }
	        self.removeClass(node, "fm-selected");
	        self.addClass(node, "fm-multdisabled");
	        isMultipleValDisabled = true;
	        node.innerHTML = "<abbr title=\"" + Labels.charts_multiple_disabled + chartType.toLocaleLowerCase() + " " + Labels.charts.toLocaleLowerCase() + "\"> <a href=\"javascript:void(0)\"><span>" + Labels.charts_multiple + "</span></a></abbr>";
	    } else if (multiple) {
	        self.addClass(node, "fm-selected");
	        self.removeClass(node, "fm-multdisabled");
	        node.innerHTML = "<a href=\"javascript:void(0)\"><span>" + Labels.charts_multiple + "</span></a>";
	        node.addEventListener("click", self.chartsMultipleHandler);
	    } else {
	        self.removeClass(node, "fm-multdisabled");
	        node.innerHTML = "<a href=\"javascript:void(0)\"><span>" + Labels.charts_multiple + "</span></a>";
	        node.addEventListener("click", self.chartsMultipleHandler);
	    }
	}

	// Format tab
	self.formatCellsHandler = function() {
		self.showFormatCellsDialog();
	}
	self.conditionalFormattingHandler = function() {
		self.showConditionalFormattingDialog();
	}

	// Options tab
	self.optionsHandler = function() {
		self.showOptionsDialog();
	}

	// Fields tab
	self.fieldsHandler = function() {
		self.pivot.openFieldsList();
	}

	// Export tab
	self.printHandler = function() {
		self.pivot.print();
	}
	self.exportHandler = function(type) {
		(type == "pdf") ? self.showExportPdfDialog() : self.pivot.exportTo(type);
	}

	// Fullscreen tab
	self.fullscreenHandler = function() {
		self.toggleFullscreen();
	}

	// DIALOGS

	// Connect to remote CSV
	self.showConnectToRemoteCSVDialog = function() {
		var applyHandler = function() {
		    if (textInput.value.length > 0) {
				self.pivot.connectTo({ filename: textInput.value, dataSourceType: "csv" });
			}
		}
		var dialog = isMobile ? new PopUpWindowMobile() : new PopUpWindow();
		dialog.setTitle(isMobile ? Labels.csv : Labels.open_remote_csv);
		dialog.setToolbar([
			{ id: "fm-btn-open", label: Labels.open, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);
		
		var content = document.createElement("table");
		content.id = isMobile ? "fm-remote-csv-mobile" : "fm-popup-remote-csv";
		content.className = "fm-form";

		var textInput = document.createElement("input");
		textInput.id = "fm-inp-file-url";
        textInput.type = "text";
        textInput.style.width = isMobile ? "99%" : "280px";
        textInput.value = "http://www.flexmonster.com/download/data.csv";
        
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(textInput);
        tr.appendChild(td);
        content.appendChild(tr);
     	
        dialog.setContent(content);
		PopUpManager.addPopUp(dialog.content);
	}


	// Connect to OLAP (XMLA)
	self.showConnectToOLAPDialog = function() {
		var onConnectBtnClick = function() {
			if (proxyUrlInput.value.length == 0) return;
			var credentialsCeckBox = document.getElementById("fm-credentials-checkbox");
			self.pivot.getXMLADataSources(proxyUrlInput.value, 
				dataSourcesHandler,
                credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-username-input").value : null,
                credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-password-input").value : null);
		};
		var dataSourcesHandler = function(dataProvider) {
	    	if (dataProvider != null && dataProvider.length > 0) {
	    		fillList(olapDataSourcesList, dataProvider, Labels.select_data_source);
	    	}
    	};
		var onOlapDataSourcesListChange = function() {
		    var credentialsCeckBox = document.getElementById("fm-credentials-checkbox");
			self.pivot.getXMLACatalogs(proxyUrlInput.value, 
				olapDataSourcesList.value, 
				catalogsHandler,
                credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-username-input").value : null,
                credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-password-input").value : null);
		};
		var catalogsHandler = function(dataProvider) {
			if (dataProvider != null && dataProvider.length > 0) {
				fillList(olapCatalogsList, dataProvider, Labels.select_catalog);
			}
		};
		var onOlapCatalogsListChange = function() {
		    var credentialsCeckBox = document.getElementById("fm-credentials-checkbox");
			self.pivot.getXMLACubes(proxyUrlInput.value, olapDataSourcesList.value, olapCatalogsList.value, 
				cubesHandler,
                credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-username-input").value : null,
                credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-password-input").value : null);
		};
		var cubesHandler = function(dataProvider) {
			if (dataProvider != null && dataProvider.length > 0) {
				fillList(olapCubesList, dataProvider, Labels.select_cube);
			}
		};
		var onOlapCubesListChange = function() {
			self.removeClass(document.getElementById("fm-btn-open"), "fm-disabled");
		};
		var okHandler = function() {
		    var provider = pivot.getXMLAProviderName(proxyUrlInput.value, '');
		    var credentialsCeckBox = document.getElementById("fm-credentials-checkbox");
	    	pivot.connectTo({
				dataSourceType: provider, 
				proxyUrl: proxyUrlInput.value, 
				dataSourceInfo: olapDataSourcesList.value, 
				catalog: olapCatalogsList.value, 
				cube: olapCubesList.value,
				username: credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-username-input").value : null,
				password: credentialsCeckBox && credentialsCeckBox.checked ? document.getElementById("fm-password-input").value : null
			});
		};
		var fillList = function(list, dataProvider, prompt) {
			// clear
   			var length = list.options.length;
			for (var i = 0; i < length; i++) {
				list.options[i] = null;
			}
			// fill
    		list.options[0] = new Option(prompt, "");
    		for (var i = 0; i < dataProvider.length; i++) {
    			list.options[i+1] = new Option(dataProvider[i], dataProvider[i]);
    		}
    		list.disabled = false;
    		list.focus();	
		};
		var onUseCredentialsChange = function () {
		    var cbx = document.getElementById("fm-credentials-checkbox");
		    var useCredentials = !self.hasClass(cbx, "fm-selected");
		    if (useCredentials) {
		    	self.addClass(cbx, "fm-selected");
		    } else {
	    		self.removeClass(cbx, "fm-selected");
		    }
		    document.getElementById("fm-credentials").style.display = useCredentials ? "inline" : "none";
		}

		var dialog = isMobile? new PopUpWindowMobile() : new PopUpWindow();
		dialog.setTitle(isMobile ? Labels.connect_olap_mobile : Labels.olap_connection_tool);
		dialog.setToolbar(isMobile ? [
			{ id: "fm-btn-open", label: Labels.open, handler: okHandler, disabled: true, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		] : [
			{ id: "fm-btn-open", label: Labels.ok, handler: okHandler, disabled: true, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);

		var content = document.createElement("table");
		content.id = isMobile ? "fm-popup-connect-olap-mobile" : "fm-popup-connect-olap";
		content.className = "fm-form";
		
		var proxyInputLabel = document.createElement("tr");
		proxyInputLabel.innerHTML = '<th colspan="2">' + Labels.proxy_url + '</th>';
		content.appendChild(proxyInputLabel);

        proxyUrlInput = document.createElement("input");
        proxyUrlInput.id = "fm-inp-proxy-url";
        proxyUrlInput.type = "text";
        proxyUrlInput.className = "fm-half-input";
        proxyUrlInput.value = "http://olap.flexmonster.com/olap/msmdpump.dll";

        connectBtn = document.createElement("a");
        connectBtn.id = "fm-btn-connect";
        connectBtn.setAttribute("href", "javascript:void(0)");
        connectBtn.className = "fm-half-button";
        self.setText(connectBtn, Labels.connect);
        connectBtn.onclick = onConnectBtnClick;

		var tr = document.createElement("tr");
        var td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(proxyUrlInput);
        td.appendChild(connectBtn);
        content.appendChild(tr);
        
        // ds info
        var dsListLabel = document.createElement("tr");
        dsListLabel.innerHTML = '<th colspan="2">' + Labels.data_source_info + '</th>';
        content.appendChild(dsListLabel);
        
        olapDataSourcesList = document.createElement("select");
        olapDataSourcesList.id = "fm-lst-dsinfo";
        olapDataSourcesList.disabled = true;
        olapDataSourcesList.innerHTML = '<option value="" class="placeholder" disabled selected>'
        	+ Labels.select_data_source + '</option>';
        olapDataSourcesList.onchange = onOlapDataSourcesListChange;
        
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(olapDataSourcesList);
        content.appendChild(tr);

        var catalogsListLabel = document.createElement("tr");
        catalogsListLabel.innerHTML = '<th>' + Labels.catalog + '</th>';
        content.appendChild(catalogsListLabel);

        olapCatalogsList = document.createElement("select");
        olapCatalogsList.id = "fm-lst-catalogs";
        olapCatalogsList.disabled = true;
        olapCatalogsList.innerHTML = '<option value="" class="placeholder" disabled selected>'
        	+ Labels.select_catalog + '</option>';
        olapCatalogsList.onchange = onOlapCatalogsListChange;

        var tr = document.createElement("tr");
        var td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(olapCatalogsList);
        content.appendChild(tr);
        
        var olapCubesLabel = document.createElement("tr");
        olapCubesLabel.innerHTML = '<th colspan="2">' + Labels.cube + '</th>';
        content.appendChild(olapCubesLabel);

        olapCubesList = document.createElement("select");
        olapCubesList.id = "fm-lst-cubes";
        olapCubesList.disabled = true;
        olapCubesList.innerHTML = '<option value="" class="placeholder" disabled selected>'
        	+ Labels.select_cube + '</option>';
        olapCubesList.onchange = onOlapCubesListChange;

        var tr = document.createElement("tr");
        var td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(olapCubesList);
        content.appendChild(tr);

		dialog.setContent(content);
		PopUpManager.addPopUp(dialog.content);

		if (document.getElementById("fm-credentials-checkbox") != null) {
		    document.getElementById("fm-credentials-checkbox").onclick = onUseCredentialsChange;
		}
	}

	// Open remote report
	self.showOpenRemoteReportDialog = function() {
		var applyHandler = function() {
			if (textInput.value.length > 0) {
				self.pivot.load(textInput.value);
			}
		}
		var dialog = isMobile ? new PopUpWindowMobile() : new PopUpWindow();
		dialog.setTitle(Labels.open_remote_report);
		dialog.setToolbar([
			{ id: "fm-btn-open", label: Labels.open, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);
		var content = document.createElement("table");
		content.id = isMobile ? "fm-remote-csv-mobile" : content.id;
		content.className = "fm-form";

        var textInput = document.createElement("input");
        textInput.type = "text";
        textInput.style.width = isMobile ? "99%" : "280px";
        var options = self.pivot.getOptions() || {};
        var isFlatTable = (options.grid && options.grid.type == "flat");
        textInput.value = isFlatTable ? "http://www.flexmonster.com/reports/report-flat.xml" : "http://www.flexmonster.com/download/report.xml";
        
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(textInput);
        content.appendChild(tr);

        dialog.setContent(content);
		PopUpManager.addPopUp(dialog.content);
	}

	// Format cells
	self.showFormatCellsDialog = function() {
		var valuesDropDownChangeHandler = function() {
			var formatVO = self.pivot.getFormat(valuesDropDown.value);
			textAlignDropDown.value = (formatVO.textAlign == "left" || formatVO.textAlign == "right") ? formatVO.textAlign : "right";
			thousandsSepDropDown.value = formatVO.thousandsSeparator;
			decimalSepDropDown.value = formatVO.decimalSeparator;
			decimalPlacesDropDown.value = formatVO.decimalPlaces;
			currencySymbInput.value = formatVO.currencySymbol;
			currencyAlignDropDown.value = formatVO.currencySymbolAlign;
			nullValueInput.value = formatVO.nullValue;
			isPercentDropdown.value = (formatVO.isPercent == true) ? true : false;
		}
		var applyHandler = function() {
			var formatVO = {};
			formatVO.textAlign = textAlignDropDown.value;
			formatVO.thousandsSeparator = thousandsSepDropDown.value;
			formatVO.decimalSeparator = decimalSepDropDown.value;
			formatVO.decimalPlaces = decimalPlacesDropDown.value;
			formatVO.currencySymbol = currencySymbInput.value;
			formatVO.currencySymbolAlign = currencyAlignDropDown.value;
			formatVO.nullValue = nullValueInput.value;
			formatVO.isPercent = isPercentDropdown.value == "true" ? true : false;
			self.pivot.setFormat(formatVO, valuesDropDown.value);
			self.pivot.refresh();
		}

		var dialog = isMobile? new PopUpWindowMobile() : new PopUpWindow();
		dialog.setTitle(isMobile ? Labels.format : Labels.format_cells);
		dialog.setToolbar(isMobile ? [
			{ id: "fm-btn-apply", label: Labels.done, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]  : [
			{ id: "fm-btn-apply", label: Labels.apply, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);

		var content = document.createElement("table");
		content.id = isMobile ? "fm-popup-format-cells-mobile" : "fm-popup-format-cells";
		content.className = "fm-form";

		var valuesDropDown = document.createElement("select");
        valuesDropDown.onchange = valuesDropDownChangeHandler;
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.value);
        tr.appendChild(isMobile ? th : td);
        if(isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(valuesDropDown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        var textAlignDropDown = document.createElement("select");
        textAlignDropDown.options[0] = new Option(Labels.align_left, "left");
        textAlignDropDown.options[1] = new Option(Labels.align_right, "right");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.text_align);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(textAlignDropDown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        var thousandsSepDropDown = document.createElement("select");
        thousandsSepDropDown.options[0] = new Option(Labels.none, "");
        thousandsSepDropDown.options[1] = new Option(Labels.space, " ");
        thousandsSepDropDown.options[2] = new Option(",", ",");
        thousandsSepDropDown.options[3] = new Option(".", ".");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.thousand_separator);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(thousandsSepDropDown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        var decimalSepDropDown = document.createElement("select");
        decimalSepDropDown.options[0] = new Option(".", ".");
        decimalSepDropDown.options[1] = new Option(",", ",");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.decimal_separator);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(decimalSepDropDown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);
        
        var decimalPlacesDropDown = document.createElement("select");
        for (var i = 0; i < 11; i++) {
        	decimalPlacesDropDown.options[i] = new Option(i === 0 ? Labels.none : (i - 1), i - 1);
        }
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.decimal_places);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(decimalPlacesDropDown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        var currencySymbInput = document.createElement("input");
        currencySymbInput.type = "text";
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.currency_symbol);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(currencySymbInput);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        var currencyAlignDropDown = document.createElement("select");
        currencyAlignDropDown.options[0] = new Option(Labels.align_left, "left");
        currencyAlignDropDown.options[1] = new Option(Labels.align_right, "right");
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.currency_align);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(currencyAlignDropDown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);
        
        var nullValueInput = document.createElement("input");
        nullValueInput.type = "text";
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.null_value);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(nullValueInput);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        var isPercentDropdown = document.createElement("select");
        isPercentDropdown.options[0] = new Option(Labels.true_value, true);
        isPercentDropdown.options[1] = new Option(Labels.false_value, false);
        var tr = document.createElement("tr");
        var th = document.createElement("th");
        var td = document.createElement("td");
        self.setText(isMobile ? th : td, Labels.is_percent);
        tr.appendChild(isMobile ? th : td);
        if (isMobile) content.appendChild(tr);
        td = document.createElement("td");
        td.appendChild(isPercentDropdown);
        if (isMobile) tr = document.createElement("tr");
        tr.appendChild(td);
        content.appendChild(tr);

        dialog.setContent(content);
		PopUpManager.addPopUp(dialog.content);

		var measures = self.pivot.getMeasures();
        for (var i = 0; i < measures.length; i++) {
        	valuesDropDown.options[i] = new Option(measures[i].caption, measures[i].uniqueName);
        }
        var cell = self.pivot.getSelectedCell();
        if (cell && cell.measure) {
        	valuesDropDown.value = cell.measure.uniqueName;
        }
		valuesDropDownChangeHandler();
	}

	// Conditional formatting
	self.showConditionalFormattingDialog = function() {
		var conditions = self.pivot.getAllConditions();
		var applyHandler = function() {
			self.pivot.removeAllConditions();
			for (var i = 0; i < conditions.length; i++) {
				var formula = composeFormula(conditions[i].sign, conditions[i].value1, conditions[i].value2);
				if (formula == null) return;
				conditions[i].formula = formula;
				self.pivot.addCondition(conditions[i]);
			}
	        self.pivot.refresh();
		};
		var onAddConditionBtnClick = function() {
	        var condition = {
                isTotal: -1,
                sign: "<",
                value1: "0",
                measures: self.pivot.getMeasures(),
                trueStyle: { fontFamily: 'Arial', fontSize: 12, color: '#000000', backgroundColor: '#FFFFFF' }
            };
            conditions.push(condition);
            conditionsList.appendChild(self.createConditionalFormattingItem(condition, conditions));
	    };
		var composeFormula = function(sign, value1, value2) {
	        var formula = '';
	        var firstValueEmpty = (value1 == null || value1.length == 0);
	        var secondValueEmpty = (value2 == null || value2.length == 0);
	        var isBetween = (sign === '><');
	        if (firstValueEmpty || (isBetween && secondValueEmpty)) {
	            return formula;
	        }
	        if (isBetween && !secondValueEmpty) {
	            formula = "if(AND(#value > " + value1 + ", #value < " + value2 + "), 'trueStyle')";
	        } else {
	            var isString = isNaN(parseFloat(value1));
	            if (isString) {
	                value1 = "'" + value1 + "'";
	            }
	            formula = "if(#value " + sign + " " + value1 + ", 'trueStyle')";
	        }
	        return formula;
		};
		var parseStrings = function (input) {
		    var output = [];
		    var openQuote = false;
		    var str = "";
		    for (var i = 0; i < input.length; i++) {
		        if (input[i] == '"' || input[i] == "'") {
		            if (openQuote) {
		                output.push(str);
		            } else {
		                str = "";
		            }
		            openQuote = !openQuote;
		            continue;
		        }
		        if (openQuote) {
		            str += input[i];
		        }
		    }
		    return output;
		};
		var parseFormula = function(formula) {
			var parseNumber = /\W\d+\.*\d*/g;
			var parseSign = /<=|>=|<|>|=|=|!=/g;
			var numbers = formula.match(parseNumber);
			var strings = parseStrings(formula);
	        var signs = formula.match(parseSign);
	        if (numbers == null && strings == null) return {};
	        return {
	            value1: (numbers != null) ? numbers[0].replace(/\s/, '') : strings[0],
	            value2: (numbers != null && numbers.length > 1) ? numbers[1].replace(/\s/, '') : '',
	            sign: signs.join('')
	        };
		};
		var parseStyles = function(input) {
	        var output = {};
	        var parts = input.split(";");
	        for (var i = 0; i < parts.length; i++) {
	            if (parts[i].length == 0) continue;
	            var keyValue = parts[i].split(":");
	            output[normalizeName(keyValue[0])] = keyValue[1];
	        }
	        return output;
	    };
	    var normalizeName = function(input) {
	        if (input == "font-family") return "fontFamily";
	        if (input == "font-size") return "fontSize";
	        if (input == "background-color") return "backgroundColor";
	        return input;
	    };
		var dialog = isMobile ? new PopUpWindowMobile() : new PopUpWindow();
		dialog.setTitle(isMobile ? Labels.conditional : Labels.conditional_formatting);
		dialog.setToolbar(isMobile ? [
			{ id: "fm-btn-apply", label: Labels.done, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		] : [
			{ id: "fm-btn-apply", label: Labels.apply, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);
		var content = document.createElement("div");
		content.id = "fm-popup-conditional";

		var conditionsList = document.createElement("ul");
		if(isMobile) content.style.marginBottom = "23px";
		conditionsList.id = isMobile ? "fm-conditions-list-mobile" : "fm-conditions-list";
        content.appendChild(conditionsList);
        var addConditionDiv = document.createElement("div");
        var addConditionBtn = document.createElement("a");
        addConditionDiv.style.paddingTop = "21px";
        addConditionBtn.setAttribute("href", "javascript:void(0)");
        addConditionBtn.className = isMobile ? "fm-link-button-mobile" : "fm-link-button";
        self.setText(addConditionBtn, Labels.add_condition);
        addConditionBtn.onclick = onAddConditionBtnClick;
        addConditionDiv.appendChild(addConditionBtn);
        content.appendChild(isMobile ? addConditionDiv : addConditionBtn);
        
        for (var i = 0; i < conditions.length; i++) {
			var formula = parseFormula(conditions[i].formula);
			conditions[i].value1 = formula.value1;
			conditions[i].value2 = formula.value2;
			conditions[i].sign = formula.sign;
			conditions[i].measures = pivot.getMeasures();
			if (typeof conditions[i].trueStyle == "string") {
	            conditions[i].trueStyle = parseStyles(conditions[i].trueStyle);
	        }
        	conditionsList.appendChild(self.createConditionalFormattingItem(conditions[i], conditions));
        }
		dialog.setContent(content);
		PopUpManager.addPopUp(dialog.content);
	};
	var DEFAULT_FONT_SIZES = [ "8px", "9px", "10px", "11px", "12px", "13px", "14px" ];
    var DEFAULT_FONTS = [ 'Arial', 'Lucida Sans Unicode', 'Verdana', 'Courier New', 'Palatino Linotype', 'Tahoma', 'Impact', 'Trebuchet MS', 'Georgia', 'Times New Roman' ];
    var DEFAULT_CONDITIONS = [
    	{ label: Labels.less_than, sign: '<' }, 
    	{ label: Labels.less_than_or_equal, sign: '<=' }, 
    	{ label: Labels.greater_than, sign: '>' }, 
    	{ label: Labels.greater_than_or_equal, sign: '>=' },
    	{ label: Labels.equal_to, sign: '=' }, 
    	{ label: Labels.not_equal_to, sign: '!=' }, 
    	{ label: Labels.between, sign: '><'}
    ];
    self.createConditionalFormattingItem = function (data, allConditions) {
		var fillValuesDropDown = function(measures, selectedMeasure) {
		    valuesDropDown[0] = new Option(Labels.all_values, "");
		    var options = self.pivot.getOptions() || {};
			var isFlatTable = (options.grid && options.grid.type == "flat");
	        for (var i = 0; i < measures.length; i++) {
	        	if (isFlatTable && measures[i].type == 7) { // count measure
	        		continue;
	        	}
	        	valuesDropDown[valuesDropDown.options.length] = new Option(measures[i].caption, measures[i].uniqueName);
	            // backward compatibility with 2.1
	        	if (selectedMeasure == "[Measures].[" + measures[i].uniqueName + "]") {
	        	    selectedMeasure = measures[i].uniqueName;
	        	}
	        }
	        if (selectedMeasure != null) {
	        	valuesDropDown.value = selectedMeasure;
	        } else {
	        	valuesDropDown.selectedIndex = 0;
	        }
		};
		var fillConditionsDropDown = function(selectedCondition) {
	        for (var i = 0; i < DEFAULT_CONDITIONS.length; i++) {
	            conditionsDropDown[i] = new Option(DEFAULT_CONDITIONS[i].label, DEFAULT_CONDITIONS[i].sign);
	        }
	        if (selectedCondition != null) {
	        	conditionsDropDown.value = selectedCondition;	
	        } else {
	        	conditionsDropDown.selectedIndex = 0;
	        } 
	    };
	    var fillFontFamiliesDropDown = function(selectedFont) {
		    for (var i = 0; i < DEFAULT_FONTS.length; i++) {
		        fontFamiliesDropDown[i] = new Option(DEFAULT_FONTS[i], DEFAULT_FONTS[i]);
		    }
		    fontFamiliesDropDown.value = (selectedFont == null ? 'Arial' : selectedFont);
		};
		var fillFontSizesDropDown = function(selectedFontSize) {
			for (var i = 0; i < DEFAULT_FONT_SIZES.length; i++) {
            	fontSizesDropDown[i] = new Option(DEFAULT_FONT_SIZES[i], parseInt(DEFAULT_FONT_SIZES[i]));
	        }
	        if (selectedFontSize != null) {
	        	selectedFontSize = parseInt(selectedFontSize);// + "px";
	        }
	        fontSizesDropDown.value = (selectedFontSize == null ? 12 : selectedFontSize);
		};
		var onValueChanged = function () {
	        data.measure = valuesDropDown.value;
	    };
	    var onFontFamilyChanged = function() {
	        if (data.trueStyle != null) {
	        	data.trueStyle.fontFamily = fontFamiliesDropDown.value;
	        	drawSample();
	        }
	    };
	    var onFontSizeChanged = function() {
	    	if (data.trueStyle != null) {
	    		data.trueStyle.fontSize = fontSizesDropDown.value;
	        	drawSample();
	    	}
	    };
		var onConditionChanged = function() {
			data.sign = conditionsDropDown.value;
			if (('sign' in data) && data.sign === '><') {
	            data.value2 = 0;
	        } else {
	            delete data.value2;
	        }
        	drawInputs();
	    };
		var onInput1Changed = function() {
	        data.value1 = (input1.value.length == 0) ? "0" : input1.value;
	    };
	    var onInput2Changed = function() {
	        data.value2 = (input2.value.length == 0) ? "0" : input2.value;
	    };
	    var onRemoveBtnClick = function() {
	    	var idx = allConditions.indexOf(data);
	    	if (idx > -1) {
	    		allConditions.splice(idx, 1);
	    	}
	        itemRenderer.parentNode.removeChild(itemRenderer);
	    };
	    var onTextColorChanged = function() {
	    	if (data.trueStyle != null) {
		    	data.trueStyle.color = textColorPicker.color.value;
		        drawSample();
	    	}
	    };
	    var onBgColorChanged = function() {
	    	if (data.trueStyle != null) {
	    		data.trueStyle.backgroundColor = bgColorPicker.color.value;
	        	drawSample();
	    	}
	    };
	    var drawInputs = function() {
	        if (('sign' in data) && data.sign === '><') {
	            self.removeClass(input1, "fm-wide");
	            input2.value = ('value2' in data ? data.value2 : "0");
	            input2.style.display = "inline-block";
	            andLabel.style.display = "inline-block";
	        } else {
	            self.addClass(input1, "fm-wide");
	            input2.style.display = "none";
	            andLabel.style.display = "none";
	        }
	    };
	    var drawSample = function() {
	        var trueStyle = data.trueStyle;
	        if (trueStyle != null) {
		        sample.style.backgroundColor = trueStyle.backgroundColor || '#fff';
		        sample.style.color = trueStyle.color || '#000';
		        sample.style.fontFamily = trueStyle.fontFamily || 'Arial';
		        sample.style.fontSize = trueStyle.fontSize || '12px';
	        }
	    };

		var itemRenderer = document.createElement("li");
		var leftContainer = document.createElement("div");
		leftContainer.className = "fm-left-container";
        var firstRow = document.createElement("div");
        var secondRow = document.createElement("div");

        var valuesDropDown = document.createElement("select");
        valuesDropDown.id = "fm-values";
        if ('measures' in data) {
            fillValuesDropDown(data.measures, data.measure);
            valuesDropDown.disabled = (data.measures.length === 0);
        } else {
            valuesDropDown.disabled = true;
        }
        valuesDropDown.onchange = onValueChanged;
        firstRow.appendChild(valuesDropDown);

        var conditionsDropDown = document.createElement("select");
        conditionsDropDown.id = "fm-conditions";
        fillConditionsDropDown(!('sign' in data) ? null : data.sign);
        conditionsDropDown.onchange = onConditionChanged;
        firstRow.appendChild(conditionsDropDown);

        var input1 = document.createElement("input");
        input1.type = "number";
        input1.value = ('value1' in data ? data.value1 : "0");
        input1.onchange = onInput1Changed;
        firstRow.appendChild(input1);

        var andLabel = document.createElement("span");
        andLabel.id = "fm-and-label";
        self.setText(andLabel, isMobile ? Labels.and_symbole : Labels.and);
        firstRow.appendChild(andLabel);

        var input2 = document.createElement("input");
        input2.type = "number";
        input2.value = ('value2' in data ? data.value2 : "0");
        input2.onchange = onInput2Changed;
        firstRow.appendChild(input2);

        drawInputs();

        var fontFamiliesDropDown = document.createElement("select");
        fontFamiliesDropDown.id = "fm-font-family";
        fillFontFamiliesDropDown((data.hasOwnProperty('trueStyle')) && (data.trueStyle.hasOwnProperty('fontFamily')) ? data.trueStyle.fontFamily : null);
        fontFamiliesDropDown.onchange = onFontFamilyChanged;
        secondRow.appendChild(fontFamiliesDropDown);

        var fontSizesDropDown = document.createElement("select");
        fontSizesDropDown.id = "fm-font-size";
        fillFontSizesDropDown((data.hasOwnProperty('trueStyle')) && (data.trueStyle.hasOwnProperty('fontSize')) ? data.trueStyle.fontSize : null);
        fontSizesDropDown.onchange = onFontSizeChanged;
       	secondRow.appendChild(fontSizesDropDown);

        var textColorPicker = document.createElement("div");
        textColorPicker.className = isMobile ? "fm-colorPicker-mobile" : "fm-colorPicker";
        textColorPicker.color = new ColorPicker.color(textColorPicker);
        textColorPicker.color.changeHandler = onTextColorChanged;
        textColorPicker.color.setValue((data.hasOwnProperty('trueStyle')) && (data.trueStyle.hasOwnProperty('color')) ? data.trueStyle.color : '0x000000');
        secondRow.appendChild(textColorPicker);

        var bgColorPicker = document.createElement("div");
        bgColorPicker.className = (isMobile ? "fm-colorPicker-mobile" : "fm-colorPicker") + " fm-bgColorPicker";
        bgColorPicker.color = new ColorPicker.color(bgColorPicker);
        bgColorPicker.color.changeHandler = onBgColorChanged;
        bgColorPicker.color.setValue((data.hasOwnProperty('trueStyle')) && (data.trueStyle.hasOwnProperty('backgroundColor')) ? data.trueStyle.backgroundColor : '0xFFFFFF');
        secondRow.appendChild(bgColorPicker);

        var sample = document.createElement("div");
        sample.className = "fm-sample";
        if (isMobile) {
            sample.style.height = "28px";
            sample.style.lineHeight = "28px";
            sample.style.width = "78px";
            sample.style.border = "1px solid #999";
        }
        self.setText(sample, "73.93");
        secondRow.appendChild(sample);
        drawSample();

        var labelThenDiv = document.createElement("div");
        labelThenDiv.style.fontWeight = "bold";
        labelThenDiv.style.marginBottom = "10px";
        var labelThen = document.createElement("label");
        self.setText(labelThen, Labels.then);
        labelThenDiv.appendChild(labelThen);

        leftContainer.appendChild(firstRow);
        if (isMobile) leftContainer.appendChild(labelThenDiv);
        leftContainer.appendChild(secondRow);

        
        var labelIfDiv = document.createElement("div");
        labelIfDiv.style.marginBottom = "10px";
        labelIfDiv.style.textIndent = "15px";
        labelIfDiv.style.fontWeight = "bold";
        var labelIF = document.createElement("label");
        labelIfDiv.appendChild(labelIF);
        self.setText(labelIF, Labels.if);        

        var removeDiv = document.createElement("div");
        removeDiv.style.marginBottom = "15px";
        var removeBtn = document.createElement("a");
        if (isMobile) {
            self.setText(removeBtn, Labels.delete);
            removeBtn.style.position = "absolute";
            removeBtn.style.right = "38px";
        }
        removeBtn.className = isMobile ? "fm-remove-condition-mobile" : "fm-remove-condition";
        removeBtn.onclick = onRemoveBtnClick;
        removeDiv.appendChild(removeBtn);

        if (isMobile) {
            itemRenderer.appendChild(removeDiv);
            itemRenderer.appendChild(labelIfDiv);
            itemRenderer.appendChild(leftContainer);
        } else {
            itemRenderer.appendChild(leftContainer);
            itemRenderer.appendChild(removeBtn);
            
        }
        

        return itemRenderer;
	};

	// Options
	self.showOptionsDialog = function() {
		var applyHandler = function() {
			var showGrandTotals;
			if (offRowsColsCbx.checked) {
				showGrandTotals = "off";
			} else if (onRowsColsCbx.checked) {
				showGrandTotals = "on";
			} else if (onRowsCbx.checked) {
				showGrandTotals = "rows";
			} else if (onColsCbx.checked) {
				showGrandTotals = "columns";
			}
			var showTotals;
			if (noSubTotalsCbx.checked) {
				showTotals = false;
			} else if (showSubTotalsCbx.checked) {
				showTotals = true;
			}
			var flatView;
			var classicView;
			if (classicViewCbx && classicViewCbx.checked) {
				classicView = true;
				flatView = false;
			} else if (flatViewCbx && flatViewCbx.checked) {
				flatView = true;
				classicView = false;
			} else {
				classicView = false;
				flatView = false;
			}
			var options = {
	            showGrandTotals: showGrandTotals,
	            showTotals: showTotals,
	            classicView: classicView,
	            flatView: flatView
	        };
	        self.pivot.setOptions(options);
	        self.pivot.refresh();
		}
		var dialog = isMobile ? new PopUpWindowMobile() : new PopUpWindow();
		dialog.setTitle(isMobile ? Labels.options : Labels.layout_options);
		dialog.setToolbar(isMobile ?  [
			{ id: "fm-btn-apply", label: Labels.done, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }] : [
			{ id: "fm-btn-apply", label: Labels.apply, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);
        var grandTotalsForm = document.createElement("table");
        grandTotalsForm.className = "fm-form";
        var th = document.createElement("th");
        self.setText(th, Labels.grand_totals);
        grandTotalsForm.appendChild(th);

        var subTotalsForm = document.createElement("table");
        subTotalsForm.className = "fm-form";
        var th = document.createElement("th");
        self.setText(th, Labels.subtotals);
        subTotalsForm.appendChild(th);

        var layoutForm = document.createElement("table");
        layoutForm.className = "fm-form";
        var th = document.createElement("th");
        self.setText(th, Labels.layout);
        layoutForm.appendChild(th);

        var compactViewCbx = document.createElement("input");
        compactViewCbx.type = "radio";
        compactViewCbx.name = "layout";
        compactViewCbx.id = "compactViewCbx";
        compactViewCbx.value = "true";
        compactViewCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(compactViewCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "compactViewCbx");
        self.setText(label, Labels.compact_view);
        td.appendChild(label);
        tr.appendChild(td);
        layoutForm.appendChild(tr);
        
        var classicViewCbx = document.createElement("input");
        classicViewCbx.type = "radio";
        classicViewCbx.name = "layout";
        classicViewCbx.id = "classicViewCbx";
        classicViewCbx.value = "false";
        classicViewCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(classicViewCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "classicViewCbx");
        self.setText(label, Labels.classic_view);
        td.appendChild(label);
        tr.appendChild(td);
        layoutForm.appendChild(tr);

        var options = self.pivot.getReport();

        if (!(options["dataSource"]["dataSourceType"] == "microsoft analysis services"
            || options["dataSource"]["dataSourceType"] == "mondrian" 
            || options["dataSource"]["dataSourceType"] == "iccube")) {
            var flatViewCbx = document.createElement("input");
            flatViewCbx.type = "radio";
            flatViewCbx.name = "layout";
            flatViewCbx.id = "flatViewCbx";
            flatViewCbx.value = "false";
            flatViewCbx.className = "fm-check-with-label";
            var tr = document.createElement("tr");
            var td = document.createElement("td");
            td.appendChild(flatViewCbx);
            var label = document.createElement("label");
            label.className = "fm-label-for-check";
            label.setAttribute("for", "flatViewCbx");
            self.setText(label, Labels.flat_view);
            td.appendChild(label);
            tr.appendChild(td);
            layoutForm.appendChild(tr);
        }
        

        var offRowsColsCbx = document.createElement("input");
        offRowsColsCbx.type = "radio";
        offRowsColsCbx.name = "grandTotals";
        offRowsColsCbx.id = "offRowsColsChBox";
        offRowsColsCbx.value = "off";
        offRowsColsCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(offRowsColsCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "offRowsColsChBox");
        self.setText(label, Labels.off_for_rows_and_columns);
        td.appendChild(label);
        tr.appendChild(td);
        grandTotalsForm.appendChild(tr);

        var onRowsColsCbx = document.createElement("input");
        onRowsColsCbx.type = "radio";
        onRowsColsCbx.name = "grandTotals";
        onRowsColsCbx.id = "onRowsColsChBox";
        onRowsColsCbx.value = "on";
        onRowsColsCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(onRowsColsCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "onRowsColsChBox");
        self.setText(label, Labels.on_for_rows_and_columns);
        td.appendChild(label);
        tr.appendChild(td);
        grandTotalsForm.appendChild(tr);

        var onRowsCbx = document.createElement("input");
        onRowsCbx.type = "radio";
        onRowsCbx.name = "grandTotals";
        onRowsCbx.id = "onRowsChBox";
        onRowsCbx.value = "rows";
        onRowsCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(onRowsCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "onRowsChBox");
        self.setText(label, Labels.on_for_rows);
        td.appendChild(label);
        tr.appendChild(td);
        grandTotalsForm.appendChild(tr);

        var onColsCbx = document.createElement("input");
        onColsCbx.type = "radio";
        onColsCbx.name = "grandTotals";
        onColsCbx.id = "onColsChBox";
        onColsCbx.value = "columns";
        onColsCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(onColsCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "onColsChBox");
        self.setText(label, Labels.on_for_columns);
        td.appendChild(label);
        tr.appendChild(td);
        grandTotalsForm.appendChild(tr);

        var noSubTotalsCbx = document.createElement("input");
        noSubTotalsCbx.type = "radio";
        noSubTotalsCbx.name = "subTotals";
        noSubTotalsCbx.id = "noSubtotalsChBox";
        noSubTotalsCbx.value = "false";
        noSubTotalsCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(noSubTotalsCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "noSubtotalsChBox");
        self.setText(label, Labels.do_not_show_subtotals);
        td.appendChild(label);
        tr.appendChild(td);
        subTotalsForm.appendChild(tr);
        
        var showSubTotalsCbx = document.createElement("input");
        showSubTotalsCbx.type = "radio";
        showSubTotalsCbx.name = "subTotals";
        showSubTotalsCbx.id = "allSubtotalsChBox";
        showSubTotalsCbx.value = "false";
        showSubTotalsCbx.className = "fm-check-with-label";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        td.appendChild(showSubTotalsCbx);
        var label = document.createElement("label");
        label.className = "fm-label-for-check";
        label.setAttribute("for", "allSubtotalsChBox");
        self.setText(label, Labels.show_all_subtotals);
        td.appendChild(label);
        tr.appendChild(td);
        subTotalsForm.appendChild(tr);

        var content = document.createElement("div");
        content.id = isMobile ? "fm-popup-options-mobile" : "fm-popup-options";

		var optionsTable = document.createElement("table");
        optionsTable.className = "fm-form";
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        var td1 = document.createElement("td");
        td1.style["vertical-align"] = "top";
        td.appendChild(grandTotalsForm);
        td1.appendChild(subTotalsForm);
        tr.appendChild(td);
        tr.appendChild(td1);
        optionsTable.appendChild(tr);
        var tr1 = document.createElement("tr");
        var td2 = document.createElement("td");
        td2.appendChild(layoutForm);
        tr1.appendChild(td2);
        optionsTable.appendChild(tr1);

        content.appendChild(optionsTable);

        dialog.setContent(content);
		PopUpManager.addPopUp(dialog.content);

		var options = self.pivot.getOptions() || {};
		var optionsGrid = options.grid || {};
		
		if (optionsGrid.showGrandTotals == "off" || optionsGrid.showGrandTotals == false) {
			offRowsColsCbx.checked = true;
		} else if (optionsGrid.showGrandTotals == "on" || optionsGrid.showGrandTotals == true) {
			onRowsColsCbx.checked = true;
		} else if (optionsGrid.showGrandTotals == "rows") {
			onRowsCbx.checked = true;
		} else if (optionsGrid.showGrandTotals == "columns") {
			onColsCbx.checked = true;
		}

		if (optionsGrid.showTotals == false) {
			noSubTotalsCbx.checked = true;
		} else if (optionsGrid.showTotals == true) {
			showSubTotalsCbx.checked = true;
		}

		if (optionsGrid.type == "flat" && flatViewCbx) {
			flatViewCbx.checked = true;
		} else if (optionsGrid.type == "classic" && classicViewCbx) {
			classicViewCbx.checked = true;
		} else if (compactViewCbx) {
			compactViewCbx.checked = true;
		}
	}

	// Export to PDF
	self.showExportPdfDialog = function() {
		var applyHandler = function() {
			var orientation = "portrait";
			if (landscapeRadio.checked) {
				orientation = "landscape";
			}
			self.pivot.exportTo('pdf', { pageOrientation: orientation });
		}
        var dialog = new PopUpWindow();
		dialog.setTitle(Labels.choose_page_orientation);
		dialog.setToolbar([
			{ id: "fm-btn-apply", label: Labels.apply, handler: applyHandler, isPositive: true },
			{ id: "fm-btn-cancel", label: Labels.cancel }
		]);

		var content = document.createElement("table");
		content.className = "fm-form";

		var portraitRadio = document.createElement("input");
		portraitRadio.id = "fm-portrait-radio";
		portraitRadio.type = "radio";
		portraitRadio.name = "pdfOrientation";
		portraitRadio.checked = true;
		var label = document.createElement("label");
		label.setAttribute("for", "fm-portrait-radio");
		self.setText(label, Labels.portrait);
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		td.appendChild(portraitRadio);
		td.appendChild(label);
		tr.appendChild(td);
		content.appendChild(tr);

		var landscapeRadio = document.createElement("input");
		landscapeRadio.id = "fm-landscape-radio";
		landscapeRadio.type = "radio";
		landscapeRadio.name = "pdfOrientation";
		var label = document.createElement("label");
		label.setAttribute("for", "fm-landscape-radio");
		self.setText(label, Labels.landscape);
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		td.appendChild(landscapeRadio);
		td.appendChild(label);
		tr.appendChild(td);
		content.appendChild(tr);

        dialog.setContent(content);
        PopUpManager.addPopUp(dialog.content);
	}

	// Fullscreen
	self.toggleFullscreen = function () {
        self.isFullscreen() ? self.exitFullscreen() : self.enterFullscreen(self.container);
    }
    self.isFullscreen = function () {
        return document.fullScreenElement || document.mozFullScreenElement || document.webkitFullscreenElement || document.msFullscreenElement;
    }
    self.enterFullscreen = function (element) {
    	if (element.requestFullscreen || element.webkitRequestFullScreen
    		|| element.mozRequestFullScreen || (element.msRequestFullscreen && window == top)) {
			self.containerStyle = {
    			width: self.container.style.width,
    			height: self.container.style.height,
    			position: self.container.style.position,
    			top: self.container.style.top,
    			bottom: self.container.style.bottom,
    			left: self.container.style.left,
    			right: self.container.style.right
    		};
	    	self.container.style.width = screen.width + "px";
	    	self.container.style.height = screen.height + "px";
	    	self.container.style.position = "fixed";
	    	self.container.style.top = 0;
	    	self.container.style.bottom = 0;
	    	self.container.style.left = 0;
	    	self.container.style.right = 0;
	    	
    		self.toolbarWrapper.style.width = screen.width + "px";
    	}
    	
        if (element.requestFullscreen) {
            element.requestFullscreen();
        } else if (element.webkitRequestFullScreen) {
            var ua = navigator.userAgent;
            if ((ua.indexOf("Safari") > -1) && (ua.indexOf("Chrome") == -1)) {
                element.webkitRequestFullScreen();
            } else {
                element.webkitRequestFullScreen(Element.ALLOW_KEYBOARD_INPUT);
            }
        } else if (element.mozRequestFullScreen) {
            element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) { //IE 11
        	if (window == top) {
        		element.msRequestFullscreen();
        	} else {
        		alert("Fullscreen mode in IE 11 is not currently supported while Pivot embeded in iframe.");
        	}
        }        
    }
    self.exitFullscreen = function() {
        if (document.exitFullscreen) {
            document.exitFullscreen();
        } else if (document.cancelFullscreen) {
            document.cancelFullscreen();
        } else if (document.mozCancelFullScreen) {
            document.mozCancelFullScreen();
        } else if (document.webkitExitFullScreen) {
            document.webkitExitFullScreen();
        } else if (document.webkitCancelFullScreen) { 
            document.webkitCancelFullScreen();
        } else if (document.msExitFullscreen) { //IE 11
          document.msExitFullscreen();
        }
    }

    self.onFullscreenChange = function() {
    	if (!self.isFullscreen()) {
			if (self.containerStyle) {
				self.container.style.width = self.containerStyle.width;
				self.container.style.height = self.containerStyle.height;
				self.container.style.position = self.containerStyle.position;
				self.container.style.top = self.containerStyle.top;
				self.container.style.bottom = self.containerStyle.bottom;
				self.container.style.left = self.containerStyle.left;
				self.container.style.right = self.containerStyle.right;
				self.toolbarWrapper.style.width = width;
				self.containerStyle = null;
			}
    	}
    }

    if (document["addEventListener"] != undefined) { // For IE 8
	    document.addEventListener("fullscreenchange", self.onFullscreenChange);
	    document.addEventListener("mozfullscreenchange", self.onFullscreenChange);
	    document.addEventListener("webkitfullscreenchange", self.onFullscreenChange);
	    document.addEventListener("MSFullscreenChange", self.onFullscreenChange);
    }

	// PRIVATE API

	self.nullOrUndefined = function (val) {
        return (typeof (val) === 'undefined' || val === null);
    }
    self.hasClass = function(elem, cls) {
    	return elem.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
    }
    self.addClass = function(elem, cls) {
    	if (!self.hasClass(elem, cls)) {
    		elem.className += " " + cls;
    	}
    }
    self.removeClass = function(elem, cls) {
    	if (self.hasClass(elem, cls)) {
        	var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
        	elem.className = elem.className.replace(reg, ' ');
    	}
    }
    self.setText = function(target, text) {
    	if (!target) return;
    	if (target.innerText !== undefined) {
	        target.innerText = text;
	    }
	    if (target.textContent !== undefined) {
	        target.textContent = text;
	    }
    }
	self.init = function(dataProvider) {

	    self.pivotContainer = pivotContainer;
	    self.container = this.pivotContainer;
	    self.container.style.position = (self.container.style.position == "") ? "relative" : self.container.style.position;

		self.toolbarWrapper = document.createElement("div");
		self.toolbarWrapper.id = "fm-toolbar-wrapper";
		self.toolbarWrapper.style.width = width;
		if (isMobile) {
			self.addClass(self.toolbarWrapper, "fm-mobile");
		}
		self.addClass(self.toolbarWrapper, "fm-toolbar-ui");
		self.toolbarWrapper.style.width = width;
        var toolbar = document.createElement("ul");
        toolbar.id = "fm-toolbar";
        for (var i = 0; i < dataProvider.length; i++) {
        	if (self.isDisabled(dataProvider[i])) continue;
       		if (isMobile && dataProvider[i].menu != null && dataProvider[i].collapse != true) {
       			for (var j = 0; j < dataProvider[i].menu.length; j++) {
       				if (self.isDisabled(dataProvider[i].menu[j])) continue;
       				toolbar.appendChild(self.createTab(dataProvider[i].menu[j]));
       			}
       		} else {
       			toolbar.appendChild((dataProvider[i].divider) ? self.createDivider() : self.createTab(dataProvider[i]));
       		}
       	}
       	self.toolbarWrapper.appendChild(toolbar);
        self.container.insertBefore(self.toolbarWrapper, self.container.firstChild);
	}
	self.createDivider = function() {
		var item = document.createElement("li");
		item.className = "fm-divider";
		return item;
	}
	self.createTab = function(data) {
		var tab = document.createElement("li");
		tab.id = data.id;
		var tabLink = document.createElement("a");
		tabLink.setAttribute("href", "javascript:void(0)");
		var title = document.createElement("span");
		self.setText(title, data.title);
		tabLink.appendChild(title);
		if (!self.nullOrUndefined(self[data.handler])) {
			tabLink.onclick = 
				function(handler, args) {
					return function() {
						handler.call(self, args);
					}
				} (self[data.handler], data.args);
		}
		if (!self.nullOrUndefined(self[data.onShowHandler])) {
			tabLink.onmouseover = 
				function (handler) {
					return function() {
						handler.call(self);
					}
				} (self[data.onShowHandler]);
		}
		tab.onmouseover = self.showDropdown;
		tab.onmouseout = self.hideDropdown;
		tab.appendChild(tabLink);
		if (data.menu != null && (!isMobile || data.collapse == true)) {
			tab.appendChild(self.createTabMenu(data.menu));
		}
		return tab;
	}
	self.showDropdown = function() {
		var menu = this.querySelectorAll(".fm-dropdown")[0];
		if (menu) {
			menu.style.display = "block";
			if (menu.getBoundingClientRect().right > self.toolbarWrapper.getBoundingClientRect().right) {
				menu.style.right = 0;
				self.addClass(this, "fm-align-rigth");
			}
		}
	};
	self.hideDropdown = function() {
		var menu = this.querySelectorAll(".fm-dropdown")[0];
		if (menu) {
			menu.style.display = "none";
			menu.style.right = null;
			self.removeClass(this, "fm-align-rigth");
		}
	};
	self.createTabMenu = function(dataProvider) {
		var container = document.createElement("div");
		container.className = "fm-dropdown fm-shadow-container";
        var content = document.createElement("ul");
        content.className = "fm-dropdown-content";
        for (var i = 0; i < dataProvider.length; i++) {
        	if (self.isDisabled(dataProvider[i])) continue;
			content.appendChild((dataProvider[i].divider) ? self.createMenuDivider() : self.createTab(dataProvider[i]));
        }
        container.appendChild(content);
        return container;
	}
	self.createMenuDivider = function() {
		var item = document.createElement("li");
		item.className = "fm-v-divider";
		return item;
	}
	self.isDisabled = function(data) {
		if (self.nullOrUndefined(data)) return true;
		return (data.ios === false && isIOS) || (data.android === false && isAndroid) || (data.mobile === false && isMobile);
	}
	var PopUpManager = {
		activePopUp: null,
		addPopUp: function(popup) {
			if (popup == null) return;
			this.removePopUp();
			var listener = PopUpManager.addModalOverlay();			
	        this.activePopUp = popup;
	        self.container.appendChild(popup);
	        self.container.appendChild(listener);
	        var containerRect = this.getBoundingRect(self.container);
			var popupRect = this.getBoundingRect(popup);
			var toolbarRect = this.getBoundingRect(self.toolbarWrapper);
			popup.style.zIndex = parseInt(listener.style.zIndex) + 1;
			listener.style.top = toolbarRect.height + "px";
			listener.style.height = containerRect.height - toolbarRect.height + "px";
			popup.style.left = (toolbarRect.width - popupRect.width) / 2 + "px";
			popup.style.top = isMobile ? toolbarRect.height + "px" : (containerRect.height - popupRect.height) / 2 + "px";
		},
		removePopUp: function(popup) {
		    var popup = (popup || this.activePopUp);
		    if (popup != null) {
		        self.container.removeChild(document.getElementById("fm-popUp-modal-overlay"));
			    self.container.removeChild(popup);
				this.activePopUp = null;
			}
		},
		getBoundingRect: function(target) {
			var rect = target.getBoundingClientRect();
			return {
				left: rect.left,
				right: rect.right,
				top: rect.top,
				bottom: rect.bottom,
				width: rect.width || target.clientWidth,
				height: rect.height || target.clientHeight 
			};
		},
		addModalOverlay: function () {
		    var listener = document.createElement("div");
		    listener.className = "fm-modal-overlay";
		    listener.id = "fm-popUp-modal-overlay";
		    listener.addEventListener('click',function (e) {
		        PopUpManager.removePopUp(PopUpManager.activePopUp);
		    });
		    return listener;
		}
	}


	var PopUpWindowMobile = function () {	    
	    var container = document.createElement("div");
	    container.className = "fm-ui-container-mobile";
	    var contentPanel = document.createElement("div");
	    contentPanel.className = "fm-panel-content";
	    var toolbar = document.createElement("div");
	    toolbar.className = "fm-ui-toolbar-mobile";
	    var titleLabel = document.createElement("span");
	    titleLabel.className = "fm-ui-header-display";	    
	    this.content = document.createElement("div");
	    this.content.className = "fm-popup-mobile fm-border-conf";


	    this.content.appendChild(container);
	    container.appendChild(toolbar);
	    toolbar.appendChild(titleLabel);
	    container.appendChild(contentPanel);

        
	    this.setTitle = function (title) {
	        titleLabel.innerText = title;
	    }

	    this.setContent = function (content) {
	        contentPanel.appendChild(content);
	        //while (content.firstChild) {
	        //    contentPanel.appendChild(content.firstChild);
	        //}	      
	    }

	    this.setToolbar = function (buttons) {
	        className = "fm-toolbar-ui fm-ui-btn fm-ui-mobile fm-header-btn ";
	        for (var i = buttons.length - 1; i >= 0; i--) {
	            var button = document.createElement("a");
	            button.setAttribute("href", "javascript:void(0)");
	            button.className = (i != 0) ? className + "fm-ui-left" : className + "fm-ui-right";
                if (buttons[i].id) button.id = buttons[i].id;
	            self.setText(button, buttons[i].label);
	            button.onclick =
    				function (handler) {
    				    return function () {
    				        if (handler != null) {
    				            handler.call();
    				        }
    				        PopUpManager.removePopUp();
    				    }
    				}(buttons[i].handler);
	            if (buttons[i].disabled === true) {
	                self.addClass(button, "fm-disabled");
	            } else {
	                self.removeClass(button, "fm-disabled");
	            }
	            if (buttons[i].isPositive && (isMac || isIOS)) {
	                toolbar.insertBefore(button, toolbar.firstChild);
	            } else {
	                toolbar.appendChild(button);
	            }
	        }	        
	    }

	    return this;
	}


	var PopUpWindow = function() {
        var shadow = document.createElement("div");
        shadow.className = "fm-shadow-container";
        var contentPanel = document.createElement("div");
        contentPanel.className = "fm-panel-content";
        var titleBar = document.createElement("div");
        titleBar.className = "fm-title-bar";
        var titleLabel = document.createElement("div");
        titleLabel.className = "fm-title-text";
        var closeBtn = document.createElement("a");
        closeBtn.className = "fm-close-button";
        closeBtn.onclick = function() { PopUpManager.removePopUp(); };
        var toolbar = document.createElement("div");
        toolbar.className = "fm-toolbox";
		this.content = document.createElement("div");
		this.content.className = "fm-popup fm-panel fm-toolbar-ui";

        this.content.appendChild(shadow);
        shadow.appendChild(contentPanel);
        contentPanel.appendChild(titleBar);
        contentPanel.appendChild(toolbar);
        titleBar.appendChild(titleLabel);
        titleBar.appendChild(closeBtn);
        
    	this.setTitle = function(title) {
    		self.setText(titleLabel, title);
    	}
    	this.setContent = function(content) {
    		contentPanel.insertBefore(content, toolbar)
    	}
    	this.setToolbar = function(buttons) {
    		toolbar.innerHTML = "";
    		for (var i = buttons.length - 1; i >= 0; i--) {
    			var button = document.createElement("a");
    			button.setAttribute("href", "javascript:void(0)");
    			button.className = "fm-button";
    			if (buttons[i].id) button.id = buttons[i].id;
    			self.setText(button, buttons[i].label);
    			button.onclick = 
    				function(handler) {
    					return function() {
    						if (handler != null) {
    							handler.call();
    						}
    						PopUpManager.removePopUp();
    					}
    				} (buttons[i].handler);
				if (buttons[i].disabled === true) {
					self.addClass(button, "fm-disabled");
				} else {
					self.removeClass(button, "fm-disabled");
				}
				if (buttons[i].isPositive && (isMac || isIOS)) {
					toolbar.insertBefore(button, toolbar.firstChild);
				} else {
					toolbar.appendChild(button);
				}
    		}
    		var clear = document.createElement("div");
    		clear.className = "fm-clear";
    		toolbar.appendChild(clear);
    	}
		return this;
	}
	// init
	self.pivot = pivot;
	self.init(dataProvider);

	var ColorPicker = {
	    bindClass: 'colorPicker',
	    install: function () {
	        ColorPicker.addEvent(window, 'load', ColorPicker.init);
	    },
	    init: function () {
	        ColorPicker.bind();
	    },
	    bind: function () {
	        var matchClass = new RegExp('(^|\\s)(' + ColorPicker.bindClass + ')\\s*(\\{[^}]*\\})?', 'i');
	        var inputs = document.getElementsByTagName('input');
	        for (var i = 0; i < inputs.length; i++) {
	            if (!inputs[i].color && inputs[i].className && (inputs[i].className.match(matchClass))) {
	                inputs[i].color = new ColorPicker.color(inputs[i]);
	            }
	        }
	    },
	    closePrevious: function () {
	        if (ColorPicker.currentActive && ColorPicker.currentActive.closeBox) {
	            ColorPicker.currentActive.closeBox();
	        }
	    },
	    addEvent: function (el, evnt, func) {
	        if (el.addEventListener) {
	            el.addEventListener(evnt, func, false);
	        } else if (el.attachEvent) {
	            el.attachEvent('on' + evnt, func);
	        }
	    },
	    stopEventPropagation: function (event) {
	        event = event || window.event;
	        if (event.stopPropagation) {
	            event.stopPropagation();
	        } else {
	            event.cancelBubble = true;
	        }
	    },
	    show: function (target, value) {
	        target.style.display = value ? 'block' : 'none';
	    },
	    setBgColor: function (target, value) {
	        if (ColorPicker.isColor(value)) {
	            if (target.style.setAttribute) {
	                target.style.setAttribute('backgroundColor', value);
	            } else {
	                target.style.backgroundColor = value;
	            }
	        }
	    },
	    isColor: function (value) {
	        return value.match(/^#?[0-9A-Fa-f]{6}$/g);
	    },
	    getWhere: function (el) {
	        var curleft = 0;
	        var curtop = 0;
	        var curtopscroll = 0;
	        var curleftscroll = 0;
	        if (el.offsetParent) {
	            curleft = el.offsetLeft;
	            curtop = el.offsetTop;
	            var elScroll = el;
	            while (elScroll = elScroll.parentNode) {
	                if (elScroll == self.container) {
	                    break;
	                }
	                curtopscroll = elScroll.scrollTop ? elScroll.scrollTop : 0;
	                curleftscroll = elScroll.scrollLeft ? elScroll.scrollLeft : 0;
	                curleft -= curleftscroll;
	                curtop -= curtopscroll;
	            }
	            while (el = el.offsetParent) {
	                if (el == self.container) {
	                    break;
	                }
	                curleft += el.offsetLeft;
	                curtop += el.offsetTop;
	            }
	        }
	        var isMSIE = /*@cc_on!@*/ 0;
	        var offsetX = 0;// isMSIE ? document.body.scrollLeft : window.pageXOffset;
	        var offsetY = 0;// isMSIE ? document.body.scrollTop : window.pageYOffset;
	        return {
	            top: curtop + offsetY,
	            left: curleft + offsetX
	        };
	    },
	    color: function (target) {
	        var THIS = this;
	        this.colorPickerButton = target;
	        this.dropDownBox = document.createElement('div');
	        this.dropDownBox.className = isMobile ? 'fm-swatchPanel-mobile' : 'fm-swatchPanel';
	        this.dropDownBox.onclick = function (event) {
	            ColorPicker.stopEventPropagation(event);
	        };
	        this.colorPreview = document.createElement('span');
	        this.colorPreview.className = isMobile ? 'fm-colorPreview-mobile' : 'fm-colorPreview';
	        this.dropDownBox.appendChild(this.colorPreview); /* end */
	        this.colorInput = document.createElement('input');
	        this.colorInput.type = 'text';
	        this.dropDownBox.appendChild(this.colorInput);
	        this.colorInput.onclick = function (event) {
	            ColorPicker.stopEventPropagation(event);
	        };
	        if (this.colorPickerButton.value == null || this.colorPickerButton.value.length == 0) {
	            this.colorPickerButton.value = '#000000';
	        }
	        ColorPicker.addEvent(this.colorInput, 'keyup', function (event) {
	            event = event || window.event;
	            var dispatcher = event.target || event.srcElement;
	            if (event.keyCode == 13) {
	                THIS.setValue(dispatcher.value);
	                THIS.closeBox();
	            } else {
	                onColorInputChanged(dispatcher.value);
	            }
	        });
	        this.opened = false;
	        this.openBox = function () {
	            this.opened = true;
	            var isMSIE = /*@cc_on!@*/ 0;
	            var pos = ColorPicker.getWhere(this.colorPickerButton);
                this.dropDownBox.style.top = pos.top + 26 + 'px';
                this.dropDownBox.style.left = pos.left + (isMSIE ? 0 : 1) + 'px';
	            this.setValue(this.value);
	            ColorPicker.show(this.dropDownBox, this.opened);
	        }
	        this.closeBox = function () {
	            this.opened = false;
	            ColorPicker.show(this.dropDownBox, false);
	            if (this.changeHandler) {
	                this.changeHandler();
	            }
	        }
	        this.setValue = function (colorValue) {
	            if (typeof colorValue === "string" && colorValue.indexOf("0x") == 0) {
	        		colorValue = "#" + colorValue.substr(2);
	            }
	            this.value = colorValue;
	            this.colorInput.value = colorValue;
	            ColorPicker.setBgColor(this.colorPreview, colorValue);
	            ColorPicker.setBgColor(this.colorPickerButton, colorValue);
	        }
	        function composeRGB(r, g, b) {
	            return '#' + r + g + b;
	        }
	        function onColorChanged(colorValue) {
	            THIS.setValue(colorValue);
	            THIS.closeBox();
	        }
	        function onColorCellHovered(colorValue) {
	            THIS.colorInput.value = colorValue;
	            ColorPicker.setBgColor(THIS.colorPreview, colorValue);
	        }
	        function onColorInputChanged(colorValue) {
	            if (ColorPicker.isColor(colorValue)) THIS.value = colorValue;
	            ColorPicker.setBgColor(THIS.colorPreview, colorValue);
	        }
	        this.createAndFillTable = function () {
	            var grayscale = ["00", "00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "AA", "BB", "CC", "DD", "EE", "FF", "FF"];
	            var colors = ["00", "33", "66", "99", "CC", "FF"];
	            this.colorsTable = document.createElement('table');
	            var tbody = document.createElement('tbody');
	            var tr = document.createElement('tr');
	            var td;
	            var div;
	            var currentColor;
	            for (var i = 0; i < 18; i++) {
	                td = document.createElement('td');
	                div = document.createElement('div');
	                currentColor = composeRGB(grayscale[i], grayscale[i], grayscale[i]);
	                ColorPicker.setBgColor(div, currentColor);
	                ColorPicker.addEvent(div, 'click', function (colorValue) {
	                    return function () {
	                        onColorChanged(colorValue);
	                    };
	                }(currentColor));
	                ColorPicker.addEvent(div, 'mouseover', function (colorValue) {
	                    return function () {
	                        onColorCellHovered(colorValue);
	                    };
	                }(currentColor));
	                td.appendChild(div);
	                tr.appendChild(td);
	            }
	            tbody.appendChild(tr);
	            for (var i = 0; i < 6; i++) {
	                tr = document.createElement('tr');
	                for (var j = 0; j < 3; j++)
	                    for (var k = 0; k < 6; k++) {
	                        div = document.createElement('div');
	                        currentColor = composeRGB(colors[j], colors[i], colors[k]);
	                        ColorPicker.setBgColor(div, currentColor);
	                        ColorPicker.addEvent(div, 'click', function (colorValue) {
	                            return function () {
	                                onColorChanged(colorValue);
	                            };
	                        }(currentColor));
	                        ColorPicker.addEvent(div, 'mouseover', function (colorValue) {
	                            return function () {
	                                onColorCellHovered(colorValue);
	                            };
	                        }(currentColor));
	                        td = document.createElement('td');
	                        td.appendChild(div);
	                        tr.appendChild(td);
	                    }
	                tbody.appendChild(tr);
	            }
	            for (var i = 0; i < 6; i++) {
	                tr = document.createElement('tr');
	                for (var j = 3; j < 6; j++)
	                    for (var k = 0; k < 6; k++) {
	                        div = document.createElement('div');
	                        currentColor = composeRGB(colors[j], colors[i], colors[k]);
	                        ColorPicker.setBgColor(div, currentColor);
	                        ColorPicker.addEvent(div, 'click', function (colorValue) {
	                            return function () {
	                                onColorChanged(colorValue);
	                            };
	                        }(currentColor));
	                        ColorPicker.addEvent(div, 'mouseover', function (colorValue) {
	                            return function () {
	                                onColorCellHovered(colorValue);
	                            };
	                        }(currentColor));
	                        td = document.createElement('td');
	                        td.appendChild(div);
	                        tr.appendChild(td);
	                    }
	                tbody.appendChild(tr);
	            }
	            this.colorsTable.appendChild(tbody);
	            this.dropDownBox.appendChild(this.colorsTable);
	            self.container.appendChild(this.dropDownBox);
	        };
	        this.createAndFillTable();
	        this.setValue(this.colorPickerButton.value);
	        ColorPicker.addEvent(this.colorPickerButton, 'click', function (event) {
	            ColorPicker.stopEventPropagation(event);
	            event = event || window.event;
	            var target = event.target || event.srcElement;
	            if (target && target.color && target.color.opened) {
	                ColorPicker.currentActive = false;
	                target.color.closeBox();
	            } else {
	                ColorPicker.closePrevious();
	                ColorPicker.currentActive = target.color;
	                target.color.openBox();
	            };
	        });
	        ColorPicker.addEvent(document.body, 'click', function () {
	            ColorPicker.closePrevious();
	            ColorPicker.currentActive = false;
	        });
	    }
	}
}