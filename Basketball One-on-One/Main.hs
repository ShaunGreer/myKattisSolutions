main :: IO()
main = do
  contents <- getContents
  putStrLn (findWinner contents 0 0)

findWinner :: String -> Int -> Int -> String
findWinner s a b
  | (a >= 11) = "A"
  | (b >= 11) = "B"
  | (a == 10) && (b == 10) = newRule s
  | (s!!0) == 'A' = findWinner (drop 2 s) (a + (read [(s!!1)] :: Int)) b
  | otherwise = findWinner (drop 2 s) a (b + (read [(s!!1)] :: Int))

newRule :: String -> String
newRule s
  | ((s!!0) == 'A') && ((s!!1) == '2') = "A"
  | ((s!!0) == 'B') && ((s!!1) == '2') = "B"
  | (((s!!0) == 'A') && ((s!!2) == 'A')) = "A"
  | (((s!!0) == 'B') && ((s!!2) == 'B')) = "B"
  | otherwise = newRule (drop 2 s)
