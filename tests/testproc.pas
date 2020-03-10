program testproc;
var x : integer
  proc test()
var x : integer
begin
  x := 5
end;
proc troc()
begin
  test()
end
begin
  x := 7;
  troc();
  write(x)
end.
