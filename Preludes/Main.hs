main = do
  contents <- getContents
  printKeys 1 (getKeyName $ lines contents)

printKeys :: Int -> [String] -> IO()
printKeys _ [] = return()
printKeys i (x:xs) = do
  putStrLn $ "Case " ++ (show i) ++ ": " ++ x
  printKeys (i+1) xs

getKeyName :: [String] -> [String]
getKeyName [] = []
getKeyName (x:xs)
  | (findAlternative ((words x) !! 0)) == "none" = "UNIQUE" : getKeyName xs
  | otherwise = ((findAlternative ((words x) !! 0)) ++ " " ++ ((words x) !! 1)) : getKeyName xs

findAlternative :: String -> String
findAlternative x = case x of
  "A#" -> "Bb"
  "Bb" -> "A#"
  "C#" -> "Db"
  "Db" -> "C#"
  "D#" -> "Eb"
  "Eb" -> "D#"
  "F#" -> "Gb"
  "Gb" -> "F#"
  "G#" -> "Ab"
  "Ab" -> "G#"
  otherwise -> "none"
