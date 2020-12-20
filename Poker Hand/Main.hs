main = do
  contents <- getContents
  putStrLn . show $ findStrength (words contents) []

findStrength :: [String] -> [(Char, Int)] -> Int
findStrength [] counts = getMax counts 0
findStrength (x:xs) counts = findStrength xs (increment (x!!0) counts)

increment :: Char -> [(Char, Int)] -> [(Char, Int)]
increment c [] = [(c, 1)]
increment c ((rank, count):xs)
  | c == rank = (rank, count + 1) : xs
  | otherwise = (rank, count) : increment c xs

getMax :: [(Char, Int)] -> Int -> Int
getMax [] highest = highest
getMax ((c,count):xs) highest
  | count > highest = getMax xs count
  | otherwise = getMax xs highest
