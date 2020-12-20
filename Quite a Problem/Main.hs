import Data.List
import Data.Char

main = do
  contents <- getContents
  let results = checkForProblem . lines $ contents
  putStr . unlines $ results

checkForProblem :: [String] -> [String]
checkForProblem [] = []
checkForProblem (x:xs)
  | findProblem . words $ x = "yes" : checkForProblem xs
  | otherwise = "no" : checkForProblem xs

findProblem :: [String] -> Bool
findProblem [] = False
findProblem (x:xs)
  | length x < 7 = findProblem xs
  | "problem" `isInfixOf` (Main.toLower x) = True
  | otherwise = findProblem xs

toLower :: String -> String
toLower [] = []
toLower (x:xs)
  | ord x > 64 && ord x < 91 = chr((ord x) + 32) : Main.toLower xs
  | otherwise = x : Main.toLower xs
