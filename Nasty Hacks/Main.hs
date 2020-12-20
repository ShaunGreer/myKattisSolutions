main = do
  contents <- getContents
  let contentsAsInt = readInts $ words contents
  mapM_ putStrLn . advertise . tail $ contentsAsInt

advertise :: [Int] -> [String]
advertise [] = []
advertise (r:e:c:rest)
  | (e - c) > r = "advertise" : advertise rest
  | (e - c) == r = "does not matter" : advertise rest
  | otherwise = "do not advertise" : advertise rest

readInts :: [String] -> [Int]
readInts = map read
