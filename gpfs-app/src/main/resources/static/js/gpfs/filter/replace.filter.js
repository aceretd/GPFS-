angular
    .module('AdminUI')
    .filter('replace', ReplaceFilter);

function ReplaceFilter() {
  return function (input, from, to) {
    input = input || '';
    from = from || '';
    to = to || '';
    return input.replace(new RegExp(from, 'g'), to);
  };
};