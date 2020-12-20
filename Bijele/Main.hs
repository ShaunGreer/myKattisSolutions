main :: IO ()
main = do
  input <- getContents
  let numbers = map (read :: String -> Int) (words input)
  mapM_ print (count numbers 0)

count :: [Int] -> Int -> [Int]
count [] _ = []
count (x:xs) i
  | (i == 0) || (i == 1) = (1-x) : count xs (i+1)
  | (i == 2) || (i == 3) || (i == 4) = (2-x) : count xs (i+1)
  | otherwise = (8-x) : count xs (i+1)