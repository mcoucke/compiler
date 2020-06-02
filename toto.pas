program toto;
var x : array [5] of integer;
y : integer
begin
  for y:= 0 to 5 do
  begin
    x[y] := y * 2
  end;
  y := 0;
  while y < 5 do
    begin
      write(x[y]);
      y := y + 1
    end
end.
