main :: IO()
main = do
  contents <- getContents
  let split = words contents
  putStrLn (isItHalloween split)

isItHalloween :: [String] -> String
isItHalloween (x:y:xs)
  | (x == "OCT" && y == "31") || (x == "DEC" && y == "25") = "yup"
  | otherwise = "nope"
