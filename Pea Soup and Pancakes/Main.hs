import Data.List.Split(splitOn)
import Data.Char(ord, chr)

main::IO()
main = do
  contents <- getContents
  let eachLine = tail (init (splitOn "\n" contents))
  putStrLn (findRestraunt eachLine "" False False)

findRestraunt :: [String] -> String -> Bool -> Bool -> String
findRestraunt [] restraunt hasSoup hasPancakes
  | hasSoup && hasPancakes = restraunt
  | otherwise = "Anywhere is fine I guess"
findRestraunt [x] restraunt hasSoup hasPancakes
  | x == "pea soup" = findRestraunt [] restraunt True hasPancakes
  | x == "pancakes" = findRestraunt [] restraunt hasSoup True
  | otherwise = findRestraunt [] restraunt hasSoup hasPancakes
findRestraunt (x:y:xs) restraunt hasSoup hasPancakes
  | (isDigit x) && hasSoup && hasPancakes = restraunt
  | (isDigit x) = findRestraunt xs y False False --Next restraunt
  | hasSoup && hasPancakes = restraunt
  | x == "pea soup" = findRestraunt (y:xs) restraunt True hasPancakes
  | x == "pancakes" = findRestraunt (y:xs) restraunt hasSoup True
  | otherwise = findRestraunt (y:xs) restraunt hasSoup hasPancakes

isDigit :: String -> Bool
isDigit [] = True
isDigit (x:xs)
  | (ord x) > 47 && (ord x) < 58 = isDigit xs
  | otherwise = False
