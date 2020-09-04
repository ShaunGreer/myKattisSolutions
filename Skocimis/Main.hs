main::IO()
main = do
  contents <- getContents
  let input = map readInt . words $ contents
  putStrLn . show . moves 0 $ input

moves :: Int -> [Int] -> Int
moves total (a:b:c:xs)
  --find smallest gap
  | (b == a+1) && (c == b+1) = total
  | (c - b) >=  (b - a) = moves (total + 1) [b, b + 1,c]
  | otherwise = moves (total + 1) [a, a +1 ,b]

readInt :: String -> Int
readInt = read
