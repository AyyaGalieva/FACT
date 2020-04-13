grammar FACT;

contract        : line+ EOF;

line            : (has | owes | includes) NEWLINE;

owes            : party ' OWES ' party ' ' ((amount ' ' conditions) | service);
has             : party ' HAS ' amount;
includes        : service ' INCLUDES ' (term | property);

party           : 'PARTY ' CHAR;
amount          : 'AMOUNT ' NUMBER;
conditions      : 'WHEN ' (term | event);
term            : 'TERM ' NUMBER;
service         : 'SERVICE ' CHAR;
event           : 'EVENT ' CHAR;
property        : 'PROPERTY ' CHAR;

fragment DIGIT  : [0-9];
NUMBER          : DIGIT+ ([.,] DIGIT+)? ;
CHAR            : [a-z_A-Z]+;
WHITESPACE      : (' ' | '\t') -> skip ;
NEWLINE         : ('\r'? '\n' | '\r')+ ;