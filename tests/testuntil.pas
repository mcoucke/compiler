program testuntil;
var x : integer
begin
  read(x);
  repeat
    x := x + 1;
    write(x)
  until x > 5
end.
