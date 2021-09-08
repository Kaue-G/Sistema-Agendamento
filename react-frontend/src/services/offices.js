
const offices = [
  {
    id: 'sao-paulo',
    name: 'São Paulo',
    endereco: 'R.Bela Cintra, 986 - 2º andar - Consolação, São Paulo - SP, 01415 - 906'
  },
  {
    id: 'santos',
    name: 'Santos',
    endereco: 'Prç. dos Expedicionários, 19 - Gonzaga, Santos-SP, 11065-500'
  }
]
export function getOffices() {
  return offices
}

export function getOffice(id) {
  return offices.find((office) => office.id === id)

}

