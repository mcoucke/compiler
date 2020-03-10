program testtype;
type test = array [5] of integer
var x, y : integer;
    l : test
begin
  read(x);
  for y := 0 to 4 do
  begin
    l[y] := x + y
  end;
  for y := 0 to 4 do
  begin
    write(l[y])
  end
end.
