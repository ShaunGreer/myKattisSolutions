import Data.List.Split (splitOn)

main::IO()
main = do
  contents <- getContents
  let l = read ((splitOn " " contents) !! 0) :: Int
  let n = read ((splitOn " " contents) !! 1) :: Int
  if l `mod` n == 0
    then putStrLn (show 1)
    else putStrLn (show (findRolls l n [(l`mod`n)]))

findRolls :: Int -> Int -> [Int] -> Int
findRolls l n rolls
  | l `mod` (n -(sum rolls)) == 0 = (length rolls) + 1
  | otherwise = findRolls l n ((l `mod` (n -(sum rolls))) : rolls)
