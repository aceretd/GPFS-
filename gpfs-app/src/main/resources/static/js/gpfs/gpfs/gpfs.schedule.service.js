angular.module('AdminUI')
    .service('ScheduleService', ScheduleService);

function ScheduleService($resource) {
    let scheduleService = {};
    let defaultSchedules = [
      //Schedule 1
      {
        index: 1,
        rows: [
          //Total equity under (PAS 101 or full PFRS), etc etc
          {cells: [
            {content: 'Total equity under {{answer(7500)}}'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Capitalization of costs directly attributable to site preparation'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Write-off of deferred charges that do not meet the IFRS for SMEs definition of an intangible asset'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Restatement of provision for post-employment benefits on a projected unit credit method basis'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Fair value adjustment to biological assets'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Fair value adjustment to investment property'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Restatement of investments in associates to cost'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Deferred tax adjustments'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },

      //Schedule 2
      {
        index: 2,
        rows: [
          {cells: [
            {content: 'Cash and Cash Equivalents'},
            {content: ''},
            {content: ''}
          ]},
          {cells: [
            {content: 'Cash in bank'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Cash on hold'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },

      //Schedule 24
      {
        index: 24,
        rows: [
          {cells: [
            {content: 'Unsecured - at amortized costs'},
            {content: '*'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Bank overdrafts'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Bank loans'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Related parties'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Other entities'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Redeemable preferred shares'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Convertible notes'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Others'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Secured - at amortized costs'},
            {content: '*'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Bank overdrafts'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Bank loans'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Loans from other entities'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Transferred receivables'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Finance lease liabilities'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Others'},
            {content: '13'},
            {content: '12'}
          ]}
        ]
      },
      //Schedule 25
      {
        index: 25,
        rows: [
          {cells: [
            {content: 'Share of the proceed before transaction cost(FV of liability, residual will be for equity)'},
            {content: '1'},
            {content: '2'},
            {content: '3'}
          ]},
          {cells: [
            {content: 'Prorated share in transaction cost(based on FV of both equity and liability component)'},
            {content: '1'},
            {content: '1'},
            {content: '1'}
          ]}
        ]
      },
      //Schedule 26
      {
        index: 26,
        rows: [
          {cells: [
            {content: 'Balance, beginning'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Interest charged'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Interest paid'},
            {content: '13'},
            {content: '12'}
          ]}
        ]
      },
      //Schedule 27
      {
        index: 27,
        rows: [
          {cells: [
            {content: 'Discount rate'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Expected return on plan assets'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Expected rate of salary increases'},
            {content: '13'},
            {content: '12'}
          ]}
        ]
      },
      //Schedule 28
      {
        index: 28,
        rows: [
          {cells: [
            {content: 'Current service cost'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Interest cost'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Expected return on plan assets'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Actuarial loss (gains) recognized in the year'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Effects of increase (decrease) on plan liability'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Losses (gains) arising from curtailments'},
            {content: '13'},
            {content: '12'}
          ]}
        ]
      },
      //Schedule 29
      {
        index: 29,
        rows: [
          {cells: [
            {content: 'Present value of defined benefit obligations'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Fair value of plan assets'},
            {content: '13'},
            {content: '12'}
          ]}
        ]
      },
      //Schedule 30
      {
        index: 30,
        rows: [
          {cells: [
            {content: 'Balance, [Beginning of accounting period]'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Current service cost'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Interest cost'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Contributions from plan members'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Actuarial loss (gains)'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Losses (gains) on curtailments'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Exchange difference'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Benefits paid'},
            {content: '13'}
          ]},
          {cells: [
            {content: '[Others]'},
            {content: '13'}
          ]}
        ]
      },
      //Schedule 31
      {
        index: 31,
        rows: [
          {cells: [
            {content: 'Balance, [Beginning of accounting period]'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Expected return on plan assets'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Actuarial gains (losses)'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Exchange difference'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Contributions from the employer'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Contributions from plan members'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Contributions from plan members'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Contributions from plan members'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Benefits paid'},
            {content: '13'}
          ]},
          {cells: [
            {content: 'Assets distributed on settlements'},
            {content: '13'}
          ]},
          {cells: [
            {content: '[Others]'},
            {content: '13'}
          ]}
        ]
      },
      //Schedule 32
      {
        index: 32,
        rows: [
          {cells: [
            {content: 'Equity instruments'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Debt instruments'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Property'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: '[Others]'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]}
        ]
      },
      //Schedule 33
      {
        index: 33,
        rows: [
          {cells: [
            {content: 'Amounts payable under finance leases:'},
            {content: '*'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Not later than one year'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: ' Later than one year but not later than five years'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Later than five years'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},{cells: [
            {content: 'Future finance charges'},
            {content: '*'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Present value of lease obligations'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Less: Current obligations under finance lease'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Non-current obligations under finance lease'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]}
        ]
      },      
      //Schedule 34
      {
        index: 34,
        rows: [
          {cells: [
            {content: 'Balance, beginning'},
            {content: '100'}
          ]},
          {cells: [
            {content: 'Additions provisions during the year'},
            {content: '30'}
          ]},
          {cells: [
            {content: 'Reductions arising from settlements'},
            {content: '30'}
          ]},
          {cells: [
            {content: 'Reduction resulting from remeasurement'},
            {content: '30'}
          ]},
          {cells: [
            {content: 'Reduction through reversals'},
            {content: '30'}
          ]},
          {cells: [
            {content: 'Unwinding of discount'},
            {content: '30'}
          ]},
          {cells: [
            {content: 'Effects of changes in estimates'},
            {content: '30'}
          ]}
        ]
      },
      //Schedule 36
      {
        index: 36,
        rows: [
          {cells: [
            {content: 'Balance, beginning '},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Additions during the year'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Accretion expense'},
            {content: '13'},
            {content: '12'}
          ]},
          {cells: [
            {content: 'Balance, end '},
            {content: '13'},
            {content: '12'}
          ]}
        ]
      },
      //Schedule 37
      {
        index: 37,
        rows: [
          {cells: [
            {content: 'Buy [Currency]'},
            {content: '*'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}          
          ]},
          {cells: [
            {content: 'Less than three months'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}          
          ]},
          {cells: [
            {content: 'Three to six months'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Sell [Currency]'},
            {content: '*'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},{cells: [
            {content: 'Less than three months'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Buy [Currency]'},
            {content: '*'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Less than three months'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]}
        ]
      },
      //Schedule 38
      {
        index: 38,
        rows: [
          {cells: [
            {content: 'Less than one year'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}          
          ]},
          {cells: [
            {content: 'One to two years'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}          
          ]},
          {cells: [
            {content: 'Two to five years'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]},
          {cells: [
            {content: 'Beyond five years'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'},
            {content: '12'},
            {content: '08'}
          ]}
        ]
      },
      //Schedule 39
      {
        index: 39,
        rows: [
          {cells: [
            {content: 'Ultimate/Senior Parent'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Sales of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Purchases of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Loans'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Administrative services'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Subsidiaries'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Sales of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Purchases of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Associate'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Sales of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Key management personnel'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Loans'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Retirement Fund'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Contributions from the  employer'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]}        
        ]
      },
      //Schedule 40
      {
        index: 40,
        rows: [
          {cells: [
            {content: 'Ultimate/Senior Parent'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Sales of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Purchases of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Loans'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Administrative services'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Subsidiaries'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Sales of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Purchases of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Associate'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Sales of goods'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Key management personnel'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Loans'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Retirement Fund'},
            {content: '*'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Contributions from the  employer'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]}          
        ]
      },
      //Schedule 41
      {
        index: 41,
        rows: [
          {cells: [
            {content: 'Short-term employee benefits'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Post-employment benefits'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Other long-term benefits'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Termination benefits'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Share-based payments'},
           {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 42
      {
        index: 42,
        rows: [
          {cells: [
            {content: 'Authorized:'},
            {content: '*'},
            {content: '0'}
          ]},
          {cells: [
            {content: '[Number of shares, par value per share]'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Issued and fully paid:'},
            {content: '*'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'At January 1, [Number of shares, par value per share]'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Distributions during the year'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Reacquisition’s during the year'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Conversions during the year'},
           {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Cancellations during the year'},
           {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 43
      {
        index: 43,
        rows: [
          {cells: [
            {content: 'Balance, beginning'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Acquired in the period'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Reissuance'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Cancellations'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Disposed of on exercise of options'},
           {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 44
      {
        index: 44,
        rows: [
          {cells: [
            {content: 'Additional paid-in capital'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Revaluation surplus'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Investment revaluation'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Equity compensation'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Hedging'},
           {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Appropriated retained earnings'},
           {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Option premium on convertible notes'},
           {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: '[Others]'},
           {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 45
      {
        index: 45,
        rows: [
          {cells: [
            {content: 'Balance, [Beginning of accounting period]'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Gain (loss) recognized on cash flows hedges:'},
            {content: '*'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Foreign currency forward exchange contracts'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Interest rate swaps'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Currency swaps'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Income tax related to gains losses recognized in equity'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Transferred to net income or loss:'},
            {content: '*'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Foreign currency forward exchange contracts'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Interest rate swaps'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Currency swaps'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Income tax related to amounts transferred to net income or loss'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Transferred to initial carrying amount of hedged item:'},
            {content: '*'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Foreign currency forward exchange contracts'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Currency swaps'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Income tax related to amounts transferred to initial carrying amount of hedged item'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: '[Others]'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 46
      {
        index: 46,
        rows: [
          {cells: [
            {content: 'Revenue'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Other income'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Finance costs'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Other expenses'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Income tax expense'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: '[Others]'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 47
      {
        index: 47,
        rows: [
          {cells: [
            {content: 'Cash dividends'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Property dividends'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Stock dividends'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 48
      {
        index: 48,
        rows: [
          {cells: [
            {content: 'Options outstanding, [Beginning of accounting period]'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Options granted'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Options exercise'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Options forfeited'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Options expired'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Options transferred'},
            {content: '0'},
            {content: '0'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 50
      {
        index: 50,
        rows: [
          {cells: [
            {content: 'Dividend yield'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Risk free interest rate'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Expected life'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Volatility'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      },
      //Schedule 51
      {
        index: 51,
        rows: [
          {cells: [
            {content: 'Grant date share price'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Exercise price'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Expected volatility'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Option life'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Dividend yield'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: 'Risk-free rate'},
            {content: '0'},
            {content: '0'}
          ]},
          {cells: [
            {content: '[Others]'},
            {content: '0'},
            {content: '0'}
          ]}
        ]
      }
    ];
    scheduleService.getSchedule = function (idx) {
      return defaultSchedules.find(function (schedule) {
        return schedule.index === idx;
      });
    }
    return scheduleService;
}
