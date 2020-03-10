program testwhile;
var x : integer
begin
  read(x);
  while x <= 5 do
  begin
    x := x + 1;
    write(x)
  end
end.