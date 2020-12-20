main::IO()
main = do
  contents <- getContents
  putStrLn (show (findPosition (init contents) 1))

findPosition :: String -> Int -> Int
findPosition [] pos = pos
findPosition (x:xs) pos
  | (x == 'A') && (pos == 1) = findPosition xs 2
  | (x == 'A') && (pos == 2) = findPosition xs 1
  | (x == 'B') && (pos == 2) = findPosition xs 3
  | (x == 'B') && (pos == 3) = findPosition xs 2
  | (x == 'C') && (pos == 1) = findPosition xs 3
  | (x == 'C') && (pos == 3) = findPosition xs 1
  | otherwise = findPosition xs pos
