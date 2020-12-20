main :: IO()
main = do
  line <- getLine
  let n = (read line :: Int)
  if n `mod` 2 == 0
    then putStrLn ("Bob")
    else putStrLn ("Alice")
