/**
 * AdminUI - Responsive Admin Theme
 *
 * AdminUI theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {

    // Configure Idle settings


    $urlRouterProvider.otherwise("/dashboard1");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider
        //Dashboard
        .state('dashboard1', {
            url: "/dashboard1",
            templateUrl: "views/dashboard1.html",
            data: {
                pageTitle: 'dashboard1',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: ['js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angles',
                            files: ['js/plugins/chartJs/angles.js']
                        },
                        {
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboard2', {
            url: "/dashboard2",
            templateUrl: "views/dashboard2.html",
            data: {
                pageTitle: 'Dashboard 2',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            name: 'angular-flot',
                            files: ['js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
                        },                        
                        {
                        name: 'angular.morris',
                        files: ['css/plugins/angular-morris/morris.css', 'js/plugins/angular-morris/raphael-min.js', 'js/plugins/angular-morris/morris.min.js', 'js/plugins/angular-morris/angular-morris.min.js']
                        },                        
                        {
                            insertBefore: '#adminAngular',
                            files: ['css/plugins/fullcalendar/fullcalendar.css', 'js/plugins/fullcalendar/fullcalendar.min.js', 'js/plugins/fullcalendar/gcal.js']
                        },
                        {
                            name: 'ui.calendar',
                            files: ['js/plugins/fullcalendar/calendar.js']
                        }

                    ]);
                }
            }
        })
        .state('dashboard3', {
            url: "/dashboard3",
            templateUrl: "views/dashboard3.html",
            data: {
                pageTitle: 'Dashboard 3',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            name: 'angular-flot',
                            files: ['js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            files: ['js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angles',
                            files: ['js/plugins/chartJs/angles.js']
                        },
                        {
                        files: ['css/mailbox.css', 'css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboard4', {
            url: "/dashboard4",
            templateUrl: "views/dashboard4.html",
            data: {
                pageTitle: 'Dashboard 4',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        },
                        {
                            insertBefore: '#adminAngular',
                            files: ['css/plugins/amcharts/export.css', 'css/plugins/amcharts/ameffectsanimation.css', 'css/project.css']
                        },
                        {
                            name: 'amChartsDirective',
                            files: ['js/plugins/amcharts/amcharts.js', 'js/plugins/amcharts/serial.js', 'js/plugins/amcharts/pie.js', 'js/plugins/amcharts/gantt.js', 'js/plugins/amcharts/funnel.js', 'js/plugins/amcharts/radar.js', 'js/plugins/amcharts/amstock.js', 'js/plugins/amcharts/ammap.js', 'js/plugins/amcharts/worldLow.js', 'js/plugins/amcharts/light.js', 'js/plugins/amcharts/export.min.js', 'js/plugins/amcharts/amChartsDirective.js']
                        },
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            serie: true,
                            files: ['js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js', 'js/plugins/jvectormap/jquery-jvectormap-2.0.2.css']
                        },
                        {
                            serie: true,
                            files: ['js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
                        },
                        {
                        name: 'angular-peity',
                        files: ['js/plugins/peity/jquery.peity.min.js', 'js/plugins/peity/angular-peity.js']
                        }

                    ]);
                }
            }
        })

        // GPFS company
        .state('company_list', {
        	url: '/company-list',
        	templateUrl: 'views/gpfs/company/company_list.html',
        	controller: 'CompanyListCtrl',
        	data: {
        		pageTitle: 'company list',
        		specialClass: 'page-header-fixed'
        	},
        	resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })
        .state('company_create', {
        	url: '/company-create',
        	templateUrl: 'views/gpfs/company/company_form.html',
        	controller: 'CompanyFormCtrl',
        	data: {
        		pageTitle: 'company create',
        		specialClass: 'page-header-fixed'
        	},
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: []
                        },
                        {
                            name: 'datePicker',
                            serie: true,
                            files: ['js/plugins/moment/moment.min.js', 'css/plugins/datapicker/angular-datapicker.css', 'js/plugins/datapicker/angular-datepicker.js']
                        },
                        {
                            files: ['css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('company_details', {
        	url: '/company/{companyId}',
        	templateUrl: 'views/gpfs/company/company_details.html',
        	controller: 'CompanyDetailsCtrl',
        	data: {
        		pageTitle: 'company details',
        		specialClass: 'page-header-fixed'
        	},
            resolve: {
            	company: function ($stateParams, CompanyService) {
            		return CompanyService.findOne({id: $stateParams.companyId});
            	}
            }
        })

        //GPFS Question
        .state('question_list', {
        	url: '/question-list',
        	templateUrl: 'views/gpfs/question/question_list.html',
        	controller: 'QuestionListCtrl',
        	data: {
        		pageTitle: 'question list',
        		specialClass: 'page-header-fixed'
        	},
        	resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([
                    	{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })

        // GPFS List
        .state('gpfs_list', {
        	url: '/gpfs-list',
        	templateUrl: 'views/gpfs/gpfs/gpfs_list.html',
        	controller: 'GpfsListCtrl',
        	data: {
        		pageTitle: 'gpfs list',
        		specialClass: 'page-header-fixed'
        	},
        	resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })

        // GPFS Creation
        .state('gpfs', {
        	url: '/gpfs/{companyId}',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-root.html',
        	abstract: true,
        	controller: 'GpfsRootController',
        	resolve: {
        		company: function ($stateParams, CompanyService) {
        			return CompanyService.findOne({id: $stateParams.companyId});
        		}
        	}
        })
        .state('gpfs.create', {
        	url: '/create',
        	templateUrl: 'views/gpfs/gpfs/gpfs-01-create.html'
        })

        // GPFS Update
        .state('gpfs.update', {
        	url: '/{year}',
        	template: '<ui-view></ui-view>',
        	abstract: true,
        	controller: 'GpfsUpdateController',
        	resolve: {
    			gpfs: function ($stateParams, GpfsService) {
    				return GpfsService.findByCompanyAndYear({companyId: $stateParams.companyId, year: $stateParams.year});
    			},
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                        	files: ['css/mailbox.css', 'css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                        }, {
                            files: ['js/plugins/editable-table/editable-table.js']
                        }, {
                            files: ['js/plugins/moment/moment.min.js']
                        }
                    ]);
                }
        	}
        })
        .state('gpfs.update.coa', {
        	url: '/coa',
        	templateUrl: 'views/gpfs/gpfs/gpfs-02-coa.html',
        	controller: 'GpfsCoaController',
        	resolve: {
        		loadPlugin: function($ocLazyLoad) {
        			return $ocLazyLoad.load([
        				{
	                        name: 'angularFileUpload',
	                        files: ['js/plugins/angular-file-upload/angular-file-upload.min.js']
        				}
    				]);
        		}
        	}
        })
        .state('gpfs.update.note1', {
        	url: '/note1',
        	templateUrl: 'views/gpfs/gpfs/gpfs-03-note1.html',
        	controller: 'GpfsNote1Controller',
        	resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: ['css/plugins/ui-select/select.css']
                        }
                    ]);
                }
        	}
        })
        .state('gpfs.update.note2', {
        	url: '/note2',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Financial Reporting Framework',
        	controller: 'GpfsUpdateController',
        	noteIndex: 2
        })
        .state('gpfs.update.note3', {
        	url: '/note3',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Significant Accounting Policies',
        	controller: 'GpfsUpdateController',
        	noteIndex: 3
        })
        .state('gpfs.update.note4', {
        	url: '/note4',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Transition to the PFRS for SMEs',
        	controller: 'GpfsUpdateController',
        	noteIndex: 4
        })
        .state('gpfs.update.note5', {
        	url: '/note5',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Reconciliation',
        	noteIndex: 5,
        	controller: 'GpfsUpdateController',
        	schedules: [{
    			template: 'views/gpfs/gpfs/schedule/schedule1.html',
    			after: 7200
			}]
        })
        .state('gpfs.update.note6', {
        	url: '/note6',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Explanation of the transition to the PFRS for SMEs',
        	controller: 'GpfsUpdateController',
        	noteIndex: 6
        })
        .state('gpfs.update.note7', {
        	url: '/note7',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Critical Accounting Judgements',
        	controller: 'GpfsUpdateController',
        	noteIndex: 7
        })
        .state('gpfs.update.note8', {
        	url: '/note8',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Categories of Financial Instruments',
        	controller: 'GpfsUpdateController',
        	noteIndex: 8
        })
        .state('gpfs.update.note9', {
        	url: '/note9',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Cash and Cash Equivalents',
        	controller: 'GpfsUpdateController',
        	noteIndex: 9
        })
        .state('gpfs.update.note10', {
        	url: '/note10',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Trade and Other Receivables',
        	controller: 'GpfsUpdateController',
        	noteIndex: 10
        })
        .state('gpfs.update.note11', {
        	url: '/note11',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Investment Measured at Fair Value Through Profit or Loss',
        	controller: 'GpfsUpdateController',
        	noteIndex: 11
        })
        .state('gpfs.update.note12', {
        	url: '/note12',
        	templateUrl: 'views/gpfs/gpfs/gpfs-00-generic.html',
        	title: 'Finance Lease Receivable',
        	controller: 'GpfsUpdateController',
        	noteIndex: 12
        })

        // UI Features 
        .state('ui_colors', {
            url: "/ui_colors",
            templateUrl: "views/ui_colors.html",
            data: {
                pageTitle: 'colors',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ui_buttons', {
            url: "/ui_buttons",
            templateUrl: "views/ui_buttons.html",
            data: {
                pageTitle: 'buttons',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ui_icons', {
            url: "/ui_icons",
            templateUrl: "views/ui_icons.html",
            data: {
                pageTitle: 'icons',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ui_tabs', {
            url: "/ui_tabs",
            templateUrl: "views/ui_tabs.html",
            data: {
                pageTitle: 'tabs',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ui_form', {
            url: "/ui_form",
            templateUrl: "views/ui_form.html",
            data: {
                pageTitle: 'form',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                    }]);
                }
            }
        })
        .state('timeline', {
            url: "/timeline",
            templateUrl: "views/timeline.html",
            data: {
                pageTitle: 'timeline',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/timeline.css']
                    }]);
                }
            }
        })
        .state('ui_grids', {
            url: "/ui_grids",
            templateUrl: "views/ui_grids.html",
            data: {
                pageTitle: 'grids',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ui_panels', {
            url: "/ui_panels",
            templateUrl: "views/ui_panels.html",
            data: {
                pageTitle: 'panels',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ui_typography', {
            url: "/ui_typography",
            templateUrl: "views/ui_typography.html",
            data: {
                pageTitle: 'typography',
                specialClass: 'page-header-fixed'
            }
        })
        .state('badges_labels_progress', {
            url: "/badges_labels_progress",
            templateUrl: "views/badges_labels_progress.html",
            data: {
                pageTitle: 'badges labels progress',
                specialClass: 'page-header-fixed'
            }
        })
        .state('alerts_Modal_Tooltip', {
            url: "/alerts_Modal_Tooltip",
            templateUrl: "views/alerts_Modal_Tooltip.html",
            data: {
                pageTitle: 'alerts Modal Tooltip',
                specialClass: 'page-header-fixed'
            }
        })
        .state('MediaObjects_Thumbnails', {
            url: "/MediaObjects_Thumbnails",
            templateUrl: "views/MediaObjects_Thumbnails.html",
            data: {
                pageTitle: 'MediaObjects Thumbnails',
                specialClass: 'page-header-fixed'
            }
        })

        //Features Components
        .state('components_datetime_pickers', {
            url: "/components_datetime_pickers",
            templateUrl: "views/components_datetime_pickers.html",
            data: {
                pageTitle: 'datetime pickers',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: ['js/plugins/moment/moment.min.js']
                        },
                        {
                            name: 'datePicker',
                            files: ['css/plugins/datapicker/angular-datapicker.css', 'js/plugins/datapicker/angular-datepicker.js']
                        }

                    ]);
                }
            }

        })
        .state('components_colourPikar', {
            url: "/components_colourPikar",
            templateUrl: "views/components_colourPikar.html",
            data: {
                pageTitle: 'colourPikar',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([

                        {
                            name: 'colorpicker.module',
                            files: ['css/plugins/colorpicker/colorpicker.css', 'js/plugins/colorpicker/bootstrap-colorpicker-module.js']
                        }

                    ]);
                }
            }

        })
        .state('components_Image_Cropping', {
            url: "/components_Image_Cropping",
            templateUrl: "views/components_Image_Cropping.html",
            data: {
                pageTitle: 'Image Cropping',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            name: 'ngImgCrop',
                            files: ['js/plugins/ngImgCrop/ng-img-crop.js', 'css/plugins/ngImgCrop/ng-img-crop.css']
                        }

                    ]);
                }
            }
        })
        .state('components_Text_Editing', {
            url: "/components_Text_Editing",
            templateUrl: "views/components_Text_Editing.html",
            data: {
                pageTitle: 'Text Editor',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        name: 'summernote',
                        files: ['css/plugins/summernote/summernote.css', 'css/plugins/summernote/summernote-bs3.css', 'js/plugins/summernote/summernote.min.js', 'js/plugins/summernote/angular-summernote.min.js']
                    }]);
                }
            }
        })
        .state('components_RangeSlider', {
            url: "/components_RangeSlider",
            templateUrl: "views/components_RangeSlider.html",
            data: {
                pageTitle: 'Range Slider',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/plugins/ionRangeSlider/ion.rangeSlider.css', 'css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css', 'js/plugins/ionRangeSlider/ion.rangeSlider.min.js']
                    }]);
                }
            }
        })
        .state('components_fileinput', {
            url: "/components_fileinput",
            templateUrl: "views/components_fileinput.html",
            data: {
                pageTitle: 'fileinput',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        name: 'angularFileUpload',
                        files: ['js/plugins/angular-file-upload/angular-file-upload.min.js']
                    }, ]);
                }
            }
        })
        .state('components_dropDown', {
            url: "/components_dropDown",
            templateUrl: "views/components_dropDown.html",
            data: {
                pageTitle: 'dropDown',
                specialClass: 'page-header-fixed'
            }
        })

        .state('components_autocomplete', {
            url: "/components_autocomplete",
            templateUrl: "views/components_autocomplete.html",
            data: {
                pageTitle: 'Autocomplete',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        name: 'simple-autocomplete',
                        files: ['css/plugins/simple-autocomplete/simple-autocomplete.css', 'js/plugins/simple-autocomplete/simple-autocomplete.js']
                    }, ]);
                }
            }
        })

        //Tables
        .state('table_static_basic', {
            url: "/table_static_basic",
            templateUrl: "views/table_static_basic.html",
            data: {
                pageTitle: 'static table',
                specialClass: 'page-header-fixed'
            }
        })
        .state('table_datatables', {
            url: "/table_datatables",
            templateUrl: "views/table_datatables.html",
            data: {
                pageTitle: 'datatables table',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })

        //Charts
        .state('graph_amcharts', {
            url: "/graph_amcharts",
            templateUrl: "views/graph_amcharts.html",
            data: {
                pageTitle: 'graph amcharts',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            insertBefore: '#adminAngular',
                            files: ['css/plugins/amcharts/export.css', 'css/plugins/amcharts/ameffectsanimation.css']
                        },
                        {
                            name: 'amChartsDirective',
                            files: ['js/plugins/amcharts/amcharts.js', 'js/plugins/amcharts/serial.js', 'js/plugins/amcharts/pie.js', 'js/plugins/amcharts/gantt.js', 'js/plugins/amcharts/funnel.js', 'js/plugins/amcharts/radar.js', 'js/plugins/amcharts/amstock.js', 'js/plugins/amcharts/ammap.js', 'js/plugins/amcharts/worldLow.js', 'js/plugins/amcharts/light.js', 'js/plugins/amcharts/export.min.js', 'js/plugins/amcharts/amChartsDirective.js']
                        }
                    ]);
                }
            }
        })
        .state('graph_chartjs', {
            url: "/graph_chartjs",
            templateUrl: "views/graph_chartjs.html",
            data: {
                pageTitle: 'graph chartjs',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: ['js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angles',
                            files: ['js/plugins/chartJs/angles.js']
                        }
                    ]);
                }
            }
        })
        .state('graph_flotchart', {
            url: "/graph_flotchart",
            templateUrl: "views/graph_flotchart.html",
            data: {
                pageTitle: 'graph flotchart',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        serie: true,
                        name: 'angular-flot',
                        files: ['js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
                    }]);
                }
            }
        })
        .state('graph_morris', {
            url: "/graph_morris",
            templateUrl: "views/graph_morris.html",
            data: {
                pageTitle: 'graph morris',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        name: 'angular.morris',
                        files: ['css/plugins/angular-morris/morris.css', 'js/plugins/angular-morris/raphael-min.js', 'js/plugins/angular-morris/morris.min.js', 'js/plugins/angular-morris/angular-morris.min.js']
                    }]);
                }
            }
        })
        .state('graph_peity', {
            url: "/graph_peity",
            templateUrl: "views/graph_peity.html",
            data: {
                pageTitle: 'graph peity',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        name: 'angular-peity',
                        files: ['js/plugins/peity/jquery.peity.min.js', 'js/plugins/peity/angular-peity.js']
                    }]);
                }
            }
        })
        .state('graph_sparkline', {
            url: "/graph_sparkline",
            templateUrl: "views/graph_sparkline.html",
            data: {
                pageTitle: 'sparkline',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['js/plugins/sparkline/jquery.sparkline.min.js']
                    }]);
                }
            }
        })

        //widgets
        .state('widgets', {
            url: "/widgets",
            templateUrl: "views/widgets.html",
            data: { pageTitle: 'Widhets',
            specialClass: 'page-header-fixed' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            files: ['css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
                        }                        
                    ]);
                }
            }
        })

        //google maps
        .state('maps_google', {
            url: "/maps_google",
            templateUrl: "views/maps_google.html",
            data: {
                pageTitle: 'google maps',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            name: 'ui.event',
                            files: ['js/plugins/uievents/event.js']
                        },
                        {
                            name: 'ui.map',
                            files: ['js/plugins/uimaps/ui-map.js']
                        },
                    ]);
                }
            }
        })

        //Page Layouts
        .state('layout_blank_page', {
            url: "/layout_blank_page",
            templateUrl: "views/layout_blank_page.html",
            data: {
                pageTitle: 'layout_blank_page',
                specialClass: 'page-header-fixed pace-done'
            }
        })
        .state('layout_footer_fixed', {
            url: "/layout_footer_fixed",
            templateUrl: "views/layout_footer_fixed.html",
            data: {
                pageTitle: 'layout_footer_fixed',
                specialClass: 'page-header-fixed page-footer-fixed'
            }
        })
        .state('layout_sidebar_closed', {
            url: "/layout_sidebar_closed",
            templateUrl: "views/layout_sidebar_closed.html",
            data: {
                pageTitle: 'layout_sidebar_closed',
                specialClass: 'page-header-fixed  page-sidebar-closed'
            }
        })
        .state('layout_sidebar_menu_light', {
            url: "/layout_sidebar_menu_light",
            templateUrl: "views/layout_sidebar_menu_light.html",
            data: {
                pageTitle: 'layout_sidebar_menu_light',
                specialClass: 'page-header-fixed page-sidebar-menu-light'
            }
        })
        .state('layout_white', {
            url: "/layout_white",
            templateUrl: "views/layout_white.html",
            data: {
                pageTitle: 'layout_white',
                specialClass: 'page-header-fixed pace-done'
            }
        })

        //Horizontal Menu
        .state('layout_menu_dark', {
            url: "/layout_menu_dark",
            templateUrl: "views/layout_menu_dark.html",
            data: {
                pageTitle: 'layout_menu_dark',
                specialClass: 'page-header-fixed horizontal-demo-menu',
                specialHorizontal: 'hor-menu hidden-sm hidden-xs'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        insertBefore: '#adminAngular',
                        files: ['css/page-header.css']

                    }]);
                }
            }
        })

        .state('layout_menu_light', {
            url: "/layout_menu_light",
            templateUrl: "views/layout_menu_light.html",
            data: {
                pageTitle: 'layout menu light',
                specialClass: 'page-header-fixed horizontal-demo-menu',
                specialHorizontal: 'hor-menu hor-menu-light hidden-sm hidden-xs'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        insertBefore: '#adminAngular',
                        files: ['css/page-header.css']

                    }]);
                }
            }
        })

        // Mailbox 

        .state('mailbox', {
            url: "/mailbox",
            templateUrl: "views/mailbox.html",
            data: {
                pageTitle: 'mailbox',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/mailbox.css', 'css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                    }]);
                }
            }
        })

        .state('mail_detail', {
            url: "/mail_detail",
            templateUrl: "views/mail_detail.html",
            data: {
                pageTitle: 'mai _detail',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/mailbox.css', 'css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                    }]);
                }
            }
        })

        .state('mail_compose', {
            url: "/mail_compose",
            templateUrl: "views/mail_compose.html",
            data: {
                pageTitle: 'mail compose',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: ['css/mailbox.css', 'css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            files: ['css/plugins/summernote/summernote.css', 'css/plugins/summernote/summernote-bs3.css', 'js/plugins/summernote/summernote.min.js']
                        },
                        {
                            name: 'summernote',
                            files: ['css/plugins/summernote/summernote.css', 'css/plugins/summernote/summernote-bs3.css', 'js/plugins/summernote/summernote.min.js', 'js/plugins/summernote/angular-summernote.min.js']
                        }
                    ]);
                }
            }
        })
        .state('email_template', {
            url: "/email_template",
            templateUrl: "views/email_template.html",
            data: {
                pageTitle: 'email template',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/eCommerce.css']

                    }]);
                }
            }
        })

        // Mailbox 

        .state('calendar', {
            url: "/calendar",
            templateUrl: "views/calendar.html",
            data: {
                pageTitle: 'calendar',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            insertBefore: '#adminAngular',
                            files: ['css/plugins/fullcalendar/fullcalendar.css', 'js/plugins/fullcalendar/fullcalendar.min.js', 'js/plugins/fullcalendar/gcal.js']
                        },
                        {
                            name: 'ui.calendar',
                            files: ['js/plugins/fullcalendar/calendar.js']
                        }

                    ]);
                }
            }
        })

        // E-commerce
        .state('ecommerce_products_grid2', {
            url: "/ecommerce_products_grid2",
            templateUrl: "views/ecommerce_products_grid2.html",
            data: {
                pageTitle: 'products grid',
                specialClass: 'page-header-fixed page-sidebar-closed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/eCommerce.css', 'css/ecommerce_products_grid2.css', 'css/plugins/iCheck/custom.css', 'js/plugins/iCheck/icheck.min.js']
                    }]);
                }
            }
        })
        .state('ecommerce_product_list', {
            url: "/ecommerce_product_list",
            templateUrl: "views/ecommerce_product_list.html",
            data: {
                pageTitle: 'ecommerce product list',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })
        .state('ecommerce_product_detail', {
            url: "/ecommerce_product_detail",
            templateUrl: "views/ecommerce_product_detail.html",
            data: {
                pageTitle: 'product detail',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: ['css/eCommerce.css', 'css/plugins/slick/slick.css', 'css/plugins/slick/slick-theme.css', 'js/plugins/slick/slick.min.js']
                        },
                        {
                            name: 'slick',
                            files: ['js/plugins/slick/angular-slick.min.js']
                        }
                    ]);
                }
            }
        })
        .state('ecommerce-cart', {
            url: "/ecommerce-cart",
            templateUrl: "views/ecommerce-cart.html",
            data: {
                pageTitle: 'ecommerce-cart',
                specialClass: 'page-header-fixed'
            }
        })
        .state('ecommerce_products_grid1', {
            url: "/ecommerce_products_grid1",
            templateUrl: "views/ecommerce_products_grid1.html",
            data: {
                pageTitle: 'products grid',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/eCommerce.css']

                    }]);
                }
            }
        })

        // Gallery

        .state('lightbox_gallery', {
            url: "/lightbox_gallery",
            templateUrl: "views/lightbox_gallery.html",
            data: {
                pageTitle: 'lightbox gallery',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['js/plugins/blueimp/jquery.blueimp-gallery.min.js', 'css/plugins/blueimp/css/blueimp-gallery.min.css']
                    }]);
                }
            }
        })
        .state('slick_carousel', {
            url: "/slick_carousel",
            templateUrl: "views/slick_carousel.html",
            data: {
                pageTitle: 'Slick carousel',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            files: ['css/plugins/slick/slick.css', 'css/plugins/slick/slick-theme.css', 'js/plugins/slick/slick.min.js']
                        },
                        {
                            name: 'slick',
                            files: ['js/plugins/slick/angular-slick.min.js']
                        }
                    ]);
                }
            }
        })
        .state('carousel', {
            url: "/carousel",
            templateUrl: "views/carousel.html",
            data: {
                pageTitle: 'carousel',
                specialClass: 'page-header-fixed'
            }
        })

        // Appe and user pages

        .state('faq', {
            url: "/faq",
            templateUrl: "views/faq.html",
            data: {
                pageTitle: 'faq',
                specialClass: 'page-header-fixed'
            }
        })
        .state('blog', {
            url: "/blog",
            templateUrl: "views/blog.html",
            data: {
                pageTitle: 'blog',
                specialClass: 'page-header-fixed'
            }
        })
        .state('projects', {
            url: "/projects",
            templateUrl: "views/projects.html",
            data: {
                pageTitle: 'projects',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })
        .state('issue_tracker', {
            url: "/issue_tracker",
            templateUrl: "views/issue_tracker.html",
            data: {
                pageTitle: 'issue_tracker',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                            serie: true,
                            files: ['js/plugins/dataTables/datatables.min.js', 'css/plugins/dataTables/datatables.min.css']
                        },
                        {
                            serie: true,
                            name: 'datatables',
                            files: ['js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            serie: true,
                            name: 'datatables.buttons',
                            files: ['js/plugins/dataTables/angular-datatables.buttons.min.js']
                        }
                    ]);
                }
            }
        })
        .state('article', {
            url: "/article",
            templateUrl: "views/article.html",
            data: {
                pageTitle: 'article',
                specialClass: 'page-header-fixed'
            }
        })
        .state('profile', {
            url: "/profile",
            templateUrl: "views/profile.html",
            data: {
                pageTitle: 'profile',
                specialClass: 'page-header-fixed profile-page page-sidebar-closed'
            }
        })
        .state('profile_2', {
            url: "/profile_2",
            templateUrl: "views/profile_2.html",
            data: {
                pageTitle: 'profile_2',
                specialClass: 'page-header-fixed profile2-page page-sidebar-closed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        insertBefore: '#adminAngular',
                        files: ['css/profile2.css', 'css/page-header.css']
                    }]);
                }
            }
        })
        .state('search_results', {
            url: "/search_results",
            templateUrl: "views/search_results.html",
            data: {
                pageTitle: 'search_results',
                specialClass: 'page-header-fixed '
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/search-result.css']
                    }]);
                }
            }
        })
        .state('lockscreen', {
            url: "/lockscreen",
            templateUrl: "views/lockscreen.html",
            data: {
                pageTitle: 'lockscreen',
                specialClass: 'header-none sidebar-none footer-none aqua-bg  login'
            }
        })
        .state('invoice', {
            url: "/invoice",
            templateUrl: "views/invoice.html",
            data: {
                pageTitle: 'invoice',
                specialClass: 'page-header-fixed'
            },
            resolve: {
                loadPlugin: function($ocLazyLoad) {
                    return $ocLazyLoad.load([{
                        files: ['css/search-result.css']
                    }]);
                }
            }
        })
        .state('login', {
            url: "/login",
            templateUrl: "views/login.html",
            data: {
                pageTitle: 'login',
                specialClass: 'header-none sidebar-none footer-none aqua-bg  login'
            }
        })
        .state('login_v2', {
            url: "/login_v2",
            templateUrl: "views/login_v2.html",
            data: {
                pageTitle: 'login_v2',
                specialClass: 'header-none sidebar-none footer-none aqua-bg  login'
            }
        })
        .state('register', {
            url: "/register",
            templateUrl: "views/register.html",
            data: {
                pageTitle: 'register',
                specialClass: 'header-none sidebar-none footer-none aqua-bg  login'
            }
        })
        .state('register_v2', {
            url: "/register_v2",
            templateUrl: "views/register_v2.html",
            data: {
                pageTitle: 'register_v2',
                specialClass: 'header-none sidebar-none footer-none aqua-bg  login'
            }
        })

        .state('forgot_password', {
            url: "/forgot_password",
            templateUrl: "views/forgot_password.html",
            data: {
                pageTitle: 'forgot_password',
                specialClass: 'header-none sidebar-none footer-none aqua-bg  login'
            }
        })
        .state('contacts', {
            url: "/contacts",
            templateUrl: "views/contacts.html",
            data: {
                pageTitle: 'contacts',
                specialClass: 'page-header-fixed'
            }
        })
        .state('contacts_2', {
            url: "/contacts_2",
            templateUrl: "views/contacts_2.html",
            data: {
                pageTitle: 'contacts 2',
                specialClass: 'page-header-fixed'
            }
        })
        .state('404', {
            url: "/404",
            templateUrl: "views/404.html",
            data: {
                pageTitle: '404',
                specialClass: 'header-none sidebar-none footer-none gray-bg'
            }
        })
        .state('500', {
            url: "/500",
            templateUrl: "views/500.html",
            data: {
                pageTitle: '500',
                specialClass: 'header-none sidebar-none footer-none gray-bg'
            }
        });

}
angular
    .module('AdminUI')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });