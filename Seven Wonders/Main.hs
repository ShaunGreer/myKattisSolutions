import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let contentsAsList = tail (init (splitOn "" contents))
  putStrLn (show (calculate contentsAsList 0 0 0))

calculate :: [String] -> Int -> Int -> Int -> Int
calculate [] t c g
  | (t > 0) && (g > 0) && (c > 0) = (t^2) + (c^2) + (g^2) + (difference t g c)
  | otherwise = (t^2) + (c^2) + (g^2)
calculate (x:xs) t c g
  | x == "T" = calculate xs (t+1) c g
  | x == "C" = calculate xs t (c+1) g
  | otherwise = calculate xs t c (g+1)

difference :: Int -> Int -> Int -> Int
difference t c g
  | (t == 0) || (c == 0) || (g == 0) = 0
  | otherwise = 7 + difference (t-1) (c-1) (g-1)
