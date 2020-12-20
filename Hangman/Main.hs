import Data.List.Split (splitOn)

main::IO()
main = do
  contents <- getContents
  let word = (splitOn "\n" contents) !! 0
  let guesses = (splitOn "\n" contents) !! 1
  putStrLn (hangman word guesses 0)

hangman :: String -> String -> Int -> String
hangman [] _ _ = "WIN"
hangman word (x:xs) count
  | count == 10 = "LOSE"
  | x `elem` word = hangman (deleteAll x word) xs count
  | otherwise = hangman word xs (count + 1)

deleteAll :: Char -> String -> String
deleteAll x [] = []
deleteAll x (y:xs)
  | x == y = deleteAll x xs
  | otherwise = y : deleteAll x xs
